package lab.cars.service;

import lab.cars.db.model.CarsEntity;;
import lab.cars.db.dao.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CarsServiceImpl implements CarsService {

    @Autowired
    CarsRepository carsRepository;


    @Override
    public Iterable<CarsEntity> findAll() {
        return carsRepository.findAll();
    }

    @Override
    public void delete(CarsEntity game){
        carsRepository.delete(game);
    }

    @Override
    public void deleteById(String id) {
        carsRepository.delete(Long.parseLong(id));
    }

    @Override
    public CarsEntity findById(String id) {
        return carsRepository.findOne(Long.parseLong(id));
    }

    @Override
    public CarsEntity update(CarsEntity car) {
        CarsEntity tmp = carsRepository.findOne(car.getId());
        tmp = merge(tmp, car);
        carsRepository.save(tmp);
        return tmp;
    }

    private CarsEntity merge(CarsEntity original, CarsEntity badCopy){
        if(original == null)
            throw new NullPointerException("Vot Eblan!");
        if (badCopy.getCost() != null)
            original.setCost(badCopy.getCost());
        if (badCopy.getName() != null)
            original.setName(badCopy.getName());
        if (badCopy.getBrand() != null)
            original.setBrand(badCopy.getBrand());
        if (badCopy.getDescription() != null)
            original.setDescription(badCopy.getDescription());
        if (badCopy.getPhoto() != null)
            original.setPhoto(badCopy.getPhoto());
        return original;
    }
    @Override
    public void append(CarsEntity game) {
        carsRepository.save(game);
    }
}
