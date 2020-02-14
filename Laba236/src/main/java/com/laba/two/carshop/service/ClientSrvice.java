package com.laba.two.carshop.service;

import com.laba.two.carshop.model.ClientEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface ClientSrvice {
    Iterable<ClientEntity> findAll();
//    void delete(ClientEntity user);
//    void update(ClientEntity user);
//    void append(ClientEntity user);
}
