package lab.cars.service;

import lab.cars.db.model.CarsEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface CarsService {
    Iterable<CarsEntity> findAll();
    void delete(CarsEntity game);
    void deleteById(String id);
    CarsEntity findById(String id);
    CarsEntity update(CarsEntity game);
    void append(CarsEntity game);

}
