package com.ratemyseries.springboot.resource;

import com.ratemyseries.springboot.db.WebSeriesRepository;
import com.ratemyseries.springboot.domain.Rating;
import com.ratemyseries.springboot.domain.WebSeries;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;
@RestController
public class ratingResource {
    private WebSeriesRepository repository;

    public ratingResource(WebSeriesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/webSeries")
    List<WebSeries> all() {
        return this.repository.findAll();
    }

    @PostMapping("/api")
    public String postSeries(@RequestBody WebSeries series){
        this.repository.save(series);
        return series.getName()+" added";
    }

    @PutMapping("/api/{name}/{rating}")
    public Rating putRating(@PathVariable String name,@PathVariable String rating){
        WebSeries series = this.repository.findByName(name);
        Rating curRating = series.getRating();
        int total = curRating.getRecommend()+curRating.getUnSatisfied()+curRating.getUnSure()+1;
        int recommend = series.getRating().getRecommend();
        switch (rating){
            case "RECOMMEND":
                recommend += 1;
                double percent = (double)recommend/(double)total;
                series.setPercentage(percent);
                series.getRating().setRecommend(recommend);
                break;
            case "UNSATISFIED":
                int unsat = series.getRating().getUnSatisfied()+1;
                percent = (double)recommend/(double)total;
                series.setPercentage(percent);
                series.getRating().setUnSatisfied(unsat);
                break;
            case "UNSURE":
                int unsure = series.getRating().getUnSure()+1;
                percent = (double)recommend/(double)total;
                series.setPercentage(percent);
                series.getRating().setUnSure(unsure);
                break;
        }
        this.repository.save(series);
        return series.getRating();
    }

    @GetMapping("/api/topRating")
    public List<WebSeries> getRating(){
        List<WebSeries> webSeries = this.repository.findTop10ByOrderByPercentageDesc();
        return webSeries;
    }

    @DeleteMapping("/api/{name}")
    String deleteWebSeries(@PathVariable String name) {
        this.repository.deleteByName(name);
        return name + " deleted";
    }
}
