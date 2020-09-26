package com.ratemyseries.springboot.resource;

import com.ratemyseries.springboot.db.WebSeriesRepository;
import com.ratemyseries.springboot.domain.Rating;
import com.ratemyseries.springboot.domain.WebSeries;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ratingResource {
    private WebSeriesRepository repository;

    public ratingResource(WebSeriesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/webSeries")
    List<WebSeries> all() {
        return repository.findAll();
    }

    @PostMapping("/api")
    public void postSeries(@RequestBody WebSeries series){
        this.repository.save(series);
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
                series.getRating().setPercentage(percent);
                series.getRating().setRecommend(recommend);
                break;
            case "UNSATISFIED":
                int unsat = series.getRating().getUnSatisfied()+1;
                percent = (double)recommend/(double)total;
                series.getRating().setPercentage(percent);
                series.getRating().setUnSatisfied(unsat);
                break;
            case "UNSURE":
                int unsure = series.getRating().getUnSure()+1;
                percent = (double)recommend/(double)total;
                series.getRating().setPercentage(percent);
                series.getRating().setUnSure(unsure);
                break;
        }
        this.repository.save(series);
        return series.getRating();
    }
    @GetMapping("/api/topRating")
    public String getRating(){
        return "helloWorld";
    }

    @DeleteMapping("/api/{name}")
    void deleteWebSeries(@PathVariable String name) {
        this.repository.deleteByName(name);
    }
}
