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

    public Guide(Tourist tourist) {
        super(tourist.getName(), tourist.getLastname(), tourist.getEmail(), tourist.getUser(), new ArrayList<Tour>());
        this.rate = new Rate();
        this.rates = new ArrayList<>();
    }

    public void calculateRate(Rate rate){

        this.rates.add(rate);

        double sum = 0;

        for (Rate i : this.rates)
            sum = sum + i.getRate();

        this.rate = new Rate (sum / this.rates.size());
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

    public void addCreatedTour(Tour t) {
        tours.add(t);
    }
}