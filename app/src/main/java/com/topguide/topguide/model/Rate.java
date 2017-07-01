package com.topguide.topguide.model;

import java.io.Serializable;

/**
 * Created by Vanja on 30.6.2017..
 */

public class Rate implements Serializable {

    private double rate;

    public Rate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
