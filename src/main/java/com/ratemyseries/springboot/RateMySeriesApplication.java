package com.ratemyseries.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class RateMySeriesApplication {
    public static void main(String args[]){
        SpringApplication.run(RateMySeriesApplication.class,args);
    }
}
