package lab.cars.db.dao;

import lab.cars.db.model.CarsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends CrudRepository<CarsEntity, Long> {
}
