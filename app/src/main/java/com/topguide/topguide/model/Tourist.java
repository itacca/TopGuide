package com.topguide.topguide.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Igor on 6/29/2017.
 */

public class Tourist implements Serializable{

    private String name;
    private String lastname;
    private String email;
    private User user;
    private ArrayList<Tour> tours;

    public Tourist() {
        this.name = null;
        this.lastname = null;
        this.email = null;
        this.user = new User();
        this.tours = new ArrayList<>();
    }

    public Tourist(String name, String lastname, String email, User user) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.user = user;
        this.tours = new ArrayList<>();
    }

    public Tourist(String name, String lastname, String email, User user, ArrayList<Tour> tours) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.user = user;
        this.tours = tours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Tour> getTours() {
        return tours;
    }

    public void setTours(ArrayList<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tourist{");
        sb.append("name='").append(name).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }

    public void signUpForTour(Tour tour){

        boolean signed = false;

        for(Tourist t : tour.getTourists()){

            if(t.getUser().getUsername().equals(this.user.getUsername())){

                signed = true;
                break;
            }
        }

        if(!signed) {

            this.tours.add(tour);
            ArrayList<Tourist> tourists = tour.getTourists();
            tourists.add(this);
            tour.setTourists(tourists);
        }
    }

    public void signOutOfTour(Tour tour){

        boolean signed = false;

        for(Tourist t : tour.getTourists()){

            if(t.getUser().getUsername().equals(this.user.getUsername())){

                signed = true;
                break;
            }
        }

        if(signed) {

            this.tours.remove(tour);
            ArrayList<Tourist> tourists = tour.getTourists();
            tourists.remove(this);
            tour.setTourists(tourists);
        }
    }
}
