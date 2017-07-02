package com.topguide.topguide.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Vanja on 30.6.2017..
 */

public class Guide extends Tourist implements Serializable{

    private Rate rate;
    ArrayList<Rate> rates;

    public Guide() {
        this.rate = new Rate();
        this.rates = new ArrayList<>();
    }

    public Guide(String name, String lastname, String email, User user) {
        super(name, lastname, email, user);
        this.rate = new Rate();
        this.rates = new ArrayList<>();
    }

    public Guide(String name, String lastname, String email, User user, ArrayList<Tour> tours) {
        super(name, lastname, email, user, tours);
        this.rate = new Rate();
        this.rates = new ArrayList<>();
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public ArrayList<Rate> getRates() {
        return rates;
    }

    public void setRates(ArrayList<Rate> rates) {
        this.rates = rates;
    }
}
