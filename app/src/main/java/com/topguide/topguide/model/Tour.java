package com.topguide.topguide.model;

import java.util.Date;

/**
 * Created by Igor on 6/28/2017.
 */

public class Tour {

    private String name;
    private String cityName;
    private Date startDate;

    public Tour() {

    }

    public Tour(String name, String cityName, Date startDate) {
        this.name = name;
        this.cityName = cityName;
        this.startDate = startDate;
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
}
