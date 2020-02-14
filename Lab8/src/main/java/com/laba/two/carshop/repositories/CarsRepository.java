package com.laba.two.carshop.repositories;

import com.laba.two.carshop.model.CarsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends CrudRepository<CarsEntity, Long> {
}
