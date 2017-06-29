package com.topguide.topguide.model;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by Igor on 6/28/2017.
 */

public class Tour {

    private String name;
    private String cityName;
    private Date startDate;
    private int rate;

    public Tour() {

    }

    public Tour(String name, String cityName, Date startDate) {
        this.name = name;
        this.cityName = cityName;
        this.startDate = startDate;
        this.rate = 0;
    }

    public Tour(String name, String cityName, Date startDate, int a) {
        this.name = name;
        this.cityName = cityName;
        this.startDate = startDate;
        this.rate = a;
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

    public static class Compare implements Comparator<Tour> {

        @Override
        public int compare(Tour t1, Tour t2) {

            return t2.getRate() - t1.getRate();
        }
    }
}
