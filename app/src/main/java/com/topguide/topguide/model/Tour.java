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
    private int rate;
    private Pricelist price;
    private String description;
    Guide guide;
    ArrayList<Integer> grades;
    ArrayList<String> comments;
    State activeState;


    public Tour() {

    }

    public Tour(String name, String cityName, Date startDate) {
        this.name = name;
        this.cityName = cityName;
        this.startDate = startDate;
        this.rate = 0;
        this.price = new Pricelist();
        this.description = "";
        this.guide = new Guide();
        this.grades = new ArrayList<>();
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
        this.grades = new ArrayList<>();
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
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

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
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

            return t2.getRate() - t1.getRate();
        }
    }

    public void calculateRate(int rate){

        this.grades.add(rate);

        int sum = 0;

        for (int i : this.grades)
            sum = sum + i;

        this.rate = sum / this.grades.size();
    }

}
