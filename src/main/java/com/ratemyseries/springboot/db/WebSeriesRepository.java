package com.ratemyseries.springboot.db;

import com.ratemyseries.springboot.domain.WebSeries;
import com.ratemyseries.springboot.domain.WebSeries;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSeriesRepository extends MongoRepository<WebSeries, String> {

    WebSeries findByName(String name);

    void deleteByName(String name);

//    void updateRating(String name, String rating){
//        Query select = new Query();
//        select.addCriteria(Criteria.where("name").is(name))
//
//    }
}
