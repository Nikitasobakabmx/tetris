package com.laba.two.carshop.service;

import com.laba.two.carshop.model.CarsEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public interface CarsService {
    Iterable<CarsEntity> findAll();
    void delete(CarsEntity car);
    void deleteById(String id);
    Optional<CarsEntity> findById(String id);
    CarsEntity update(CarsEntity car);
    void append(CarsEntity car);

}
