package com.ratemyseries.springboot.db;

import com.ratemyseries.springboot.domain.WebSeries;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebSeriesRepository extends MongoRepository<WebSeries, String> {

    WebSeries findByName(String name);

    void deleteByName(String name);

    List<WebSeries> findTop10ByOrderByPercentageDesc();

}