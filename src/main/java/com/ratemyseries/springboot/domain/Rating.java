package com.ratemyseries.springboot.domain;

public class Rating {
    private int recommend;//: +1
    private int unSure;//: 0
    private int unSatisfied;//: -1
    private double percentage;//

    public Rating(){
        this.recommend = 0;
        this.unSure = 0;
        this.unSatisfied = 0;
        this.percentage = 0;
    }

    public Rating(int recommend, int unSure, int unSatisfied, double percentage) {
        this.recommend = recommend;
        this.unSure = unSure;
        this.unSatisfied = unSatisfied;
        this.percentage = percentage;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public int getUnSure() {
        return unSure;
    }

    public void setUnSure(int unSure) {
        this.unSure = unSure;
    }

    public int getUnSatisfied() {
        return unSatisfied;
    }

    public void setUnSatisfied(int unSatisfied) {
        this.unSatisfied = unSatisfied;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
