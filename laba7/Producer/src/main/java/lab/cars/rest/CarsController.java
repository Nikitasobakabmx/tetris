package lab.cars.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab.cars.db.model.CarsEntity;
import lab.cars.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

@RestController
@RequestMapping("/public/rest/cars")
public class CarsController {
    @Autowired
    private CarsService carsService;

    String topicName = "testTopic";
    Properties props = new Properties();
    KafkaProducer<String, String> producer = null;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> get(@RequestParam(value = "id", defaultValue = "null") String id){
        
        //init kafka topics
        props.put("bootstrap.servers", "localhost:2181");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");


        if(!id.equals("null"))
            return ResponseEntity.ok(carsService.findById(id));
        return ResponseEntity.ok(carsService.findAll());
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestParam(value = "id") String id) throws JsonProcessingException {
        producer = new KafkaProducer<>(props);
        CarsEntity tmp = new CarsEntity();
        tmp.setId(Integer.parseInt(id));

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(tmp);
        producer.send(new ProducerRecord<String, String>(topicName, "0", jsonString));

        producer.close();

        return ResponseEntity.ok("200");
    }

    @RequestMapping(method=RequestMethod.POST, consumes = "application/json", produces = { "application/json", "application/xml" })
    public @ResponseBody ResponseEntity<Object> append(@RequestBody CarsEntity entity) throws JsonProcessingException {
        producer = new KafkaProducer<>(props);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(entity);
        producer.send(new ProducerRecord<>(topicName, "1", jsonString));

        producer.close();
        return ResponseEntity.ok("200");
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public @ResponseBody ResponseEntity<Object> update(@RequestBody CarsEntity entity) throws JsonProcessingException {
        producer = new KafkaProducer<>(props);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(entity);
        producer.send(new ProducerRecord<>(topicName, "2", jsonString));

        producer.close();
        return ResponseEntity.ok("200");
    }
}
