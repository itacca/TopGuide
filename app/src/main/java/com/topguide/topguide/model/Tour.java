package com.topguide.topguide.model;

import android.support.v7.view.menu.ActionMenuItem;

import com.topguide.topguide.model.state.ActiveState;
import com.topguide.topguide.model.state.FinishedState;
import com.topguide.topguide.model.state.State;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Igor on 6/28/2017.
 */

public class Tour implements Serializable {

    private static final String ACTIVE = "Active";
    private static final String FINISHED = "Finished";
    private static final String SUSPENDED = "Suspended";
    private String name;
    private Place placeName;
    private Date startDate;
    private double rate;
    private Pricelist price;
    private String description;
    private Guide guide;
    private ArrayList<Rate> rates;
    private ArrayList<Comment> comments;
    private State state;


    public Tour() {

    }

    public Tour(String name, String placeName, Date startDate) {
        this.name = name;
        this.placeName = new Place(placeName);
        this.startDate = startDate;
        this.rate = 5;
        this.price = new Pricelist(1000, new Date());
        this.description = "*** Opsti opis ture***";
        this.guide = null;
        this.rates = new ArrayList<>();
        this.rates.add(new Rate(5.0));
        this.comments = new ArrayList<>();
        this.state = new ActiveState();
    }

    public Tour(String name, String placeName, Date startDate, int rate) {
        this.name = name;
        this.placeName = new Place(placeName);
        this.startDate = startDate;
        this.rate = rate;
        this.price = new Pricelist();
        this.description = "";
        this.guide = new Guide();
        this.rates = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.state = new ActiveState();
    }


    public Tour(String name, String placeName, Date startDate, Pricelist price, String description, Guide guide) {
        this.name = name;
        this.placeName = new Place(placeName);
        this.startDate = startDate;
        this.rate = 0;
        this.price = price;
        this.description = description;
        this.guide = guide;
        this.rates = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.state = new ActiveState();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Place getPlaceName() {
        return placeName;
    }

    public void setCityName(Place placeName) {
        this.placeName = placeName;
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

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Rate> getRates() {
        return rates;
    }

    public void setRates(ArrayList<Rate> rates) {
        this.rates = rates;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void calculateRate(int rate){

        this.rates.add(new Rate(rate));

        double sum = 0;

        for (Rate i : this.rates)
            sum = sum + i.getRate();

        this.rate = sum / this.rates.size();
    }

    public boolean returnPositiveStatus() {
        return true;
    }

    public boolean returnNegativeStatus() {
        return false;
    }

    public String returnStatusAcitve() {
        return ACTIVE;
    }

    public String returnStatusFinished() {
        return FINISHED;
    }

    public String returnStatusSuspended() {
        return SUSPENDED;
    }

    public boolean checkStartDate() {
        if (startDate.after(new Date())) {
            return true;
        } else {
            return false;
        }
    }

    public void changeState(State newState) {
        state = newState;
    }

    public static class Compare implements Comparator<Tour> {

        @Override
        public int compare(Tour t1, Tour t2) {

            if (t1.getRate() < t2.getRate()) return -1;
            if (t1.getRate() > t2.getRate()) return 1;
            return 0;
        }
    }


}
