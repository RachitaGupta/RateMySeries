package com.ratemyseries.springboot.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document("WebSeries")
public class WebSeries {
    @Id
    @Indexed(unique = true)
    private String name;
    private String genre;
    private String language;
    private Date releasedDate;
    private Rating rating;
    public WebSeries(){}

    public WebSeries(String name,String genre,String language, Date date, Rating rating) {
        this.name = name;
        this.genre = genre;
        this.language = language;
        this.releasedDate = date;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}

    public String getLanguage() {return language;}
    public void setLanguage(String language) {this.language = language;}

    public Date getReleasedDate() {return releasedDate;}
    public void setReleasedDate(Date releasedDate) {this.releasedDate = releasedDate;}

    public Rating getRating() {return rating;}
    public void setRating(Rating rating) {this.rating = rating; }
}
