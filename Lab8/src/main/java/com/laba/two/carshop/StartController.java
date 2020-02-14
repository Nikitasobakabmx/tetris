package com.laba.two.carshop;

import com.laba.two.carshop.model.CarsEntity;
import com.laba.two.carshop.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/cars")
class StartController {
    @Autowired
    private CarsService carsService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> get(@RequestParam(value = "id", defaultValue = "null") String id){
        if(!id.equals("null"))
            return ResponseEntity.ok(carsService.findById(id));
        return ResponseEntity.ok(carsService.findAll());
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestParam(value = "id") String id){
        System.out.println("Delete " + id);
        Optional<CarsEntity> tmp = carsService.findById(id);
        carsService.deleteById(id);
        return ResponseEntity.ok(tmp);
    }

    @RequestMapping(method=RequestMethod.POST, consumes = "application/json", produces = { "application/json", "application/xml" })
    public @ResponseBody ResponseEntity<Object> append(@RequestBody CarsEntity entity){
        System.out.println(entity.getName());
        carsService.append(entity);
        return ResponseEntity.ok(entity);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public @ResponseBody ResponseEntity<Object> update(@RequestBody CarsEntity entity){
        System.out.println(entity.getCost());
        System.out.println(entity.getId());
        CarsEntity tmp = carsService.update(entity);
        return ResponseEntity.ok(tmp);
    }
}

