package com.topguide.topguide.dao;
import com.topguide.topguide.model.Tour;
import com.topguide.topguide.model.Tourist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class TourDao {

    private ArrayList<Tour> tours;

    public TourDao() {
        setTours();
    }

    private void setTours() {
        tours = new ArrayList<Tour>();
        tours.add(new Tour("Obilazak restorana","Novi Sad", new Date()));
        tours.add(new Tour("Obilazak muzeja","Novi Sad", new Date()));
        tours.add(new Tour("All-round obilazak","Beograd", new Date()));
        tours.add(new Tour("Obilazak znamenitosti","Beograd",new Date()));
        tours.add(new Tour("Brza tura po gradu","Nis",new Date()));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d  = new Date();
        try {
             d = sdf.parse("21/12/2019");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tours.add(new Tour("Obilazak parkova","Nis",d));
    }

    public ArrayList<Tour> getTours() {
        Collections.sort(tours, new Tour.Compare());
        return tours;
    }

    public ArrayList<Tour> searchTours(String word) {

        ArrayList<Tour> searchedTours = new ArrayList<>();

        for(Tour t : tours){

            if(t.getPlaceName().getName().toLowerCase().contains(word.toLowerCase())) {
                searchedTours.add(t);
            }
        }

        Collections.sort(searchedTours, new Tour.Compare());

        return searchedTours;
    }

    public ArrayList<Tour> getGuideTours(String username){

        ArrayList<Tour> guideTours = new ArrayList<>();

        for (Tour t: tours){
            if (t.getGuide().getUser().getUsername().equals(username)){
                guideTours.add(t);
            }
        }
        return guideTours;
    }
}
