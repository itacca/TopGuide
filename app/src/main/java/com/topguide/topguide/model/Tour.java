package com.topguide.topguide.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Igor on 6/28/2017.
 */

public class Tour implements Serializable {

    private String name;
    private String cityName;
    private Date startDate;
    private double rate;
    private Pricelist price;
    private String description;
    Guide guide;
    ArrayList<Rate> rates;
    ArrayList<Comment> comments;
    State activeState;


    public Tour() {

    }

    public Tour(String name, String cityName, Date startDate) {
        this.name = name;
        this.cityName = cityName;
        this.startDate = startDate;
        this.rate = 0;
        this.price = new Pricelist();
        this.description = "NAJVECE ZURKE NA SVETU KOD VULETA!";
        this.guide = new Guide();
        this.rates = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.activeState = new State();
    }

    public Tour(String name, String cityName, Date startDate, int a) {
        this.name = name;
        this.cityName = cityName;
        this.startDate = startDate;
        this.rate = a;
        this.price = new Pricelist();
        this.description = "";
        this.guide = new Guide();
        this.rates = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.activeState = new State();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Pricelist getPrice() {
        return price;
    }

    public void setPrice(Pricelist price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public ArrayList<Rate> getGrades() {
        return rates;
    }

    public void setGrades(ArrayList<Rate> rates) {
        this.rates = rates;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public State getActiveState() {
        return activeState;
    }

    public void setActiveState(State activeState) {
        this.activeState = activeState;
    }

    public static class Compare implements Comparator<Tour> {

        @Override
        public int compare(Tour t1, Tour t2) {

            if (t1.getRate() < t2.getRate()) return -1;
            if (t1.getRate() > t2.getRate()) return 1;
            return 0;
        }
    }

    public void calculateRate(int rate){

        this.rates.add(new Rate(rate));

        double sum = 0;

        for (Rate i : this.rates)
            sum = sum + i.getRate();

        this.rate = sum / this.rates.size();
    }

}
