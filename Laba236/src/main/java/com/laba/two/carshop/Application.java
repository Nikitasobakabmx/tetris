package com.laba.two.carshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(scanBasePackages = {
//        "com.laba.two.restfull.db.dao",
//        "com.laba.two.restfull.db.model",
//        "com.laba.two.restfull.controller.Controller",
//        "com.laba.two.restfull.config",
//        "com.laba.two.restfull.service"})

@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories("com.laba.two.carshop.repositories")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
