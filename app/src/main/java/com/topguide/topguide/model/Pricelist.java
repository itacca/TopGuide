package com.topguide.topguide.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Vanja on 30.6.2017..
 */

public class Pricelist implements Serializable {

    private double price;
    private Date startDate;

    public Pricelist(double price, Date startDate) {
        this.price = price;
        this.startDate = startDate;
    }

    public Pricelist() {}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
