package com.laba.two.carshop.service;

import com.laba.two.carshop.model.CarsEntity;;
import com.laba.two.carshop.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class CarsServiceImpl implements CarsService {

    @Autowired
    CarsRepository gameRepository;


    @Override
    public Iterable<CarsEntity> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void delete(CarsEntity game){
        gameRepository.delete(game);
    }

    @Override
    public void deleteById(String id) {
        gameRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public Optional<CarsEntity> findById(String id) {
        return gameRepository.findById(Long.parseLong(id));
    }

    @Override
    public CarsEntity update(CarsEntity car) {
        Optional<CarsEntity> tmp = gameRepository.findById(car.getId());
        CarsEntity oneTmp = tmp.get();
        oneTmp = merge(oneTmp, car);
        gameRepository.save(oneTmp);
        return oneTmp;
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
        gameRepository.save(game);
    }
}
