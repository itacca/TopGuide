package com.topguide.topguide.dao;
import com.topguide.topguide.model.Tour;
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
    }

    public ArrayList<Tour> getTours() {
        Collections.sort(tours, new Tour.Compare());
        return tours;
    }

    public ArrayList<Tour> searchTours(String word) {

        ArrayList<Tour> searchedTours = new ArrayList<>();

        for(Tour t : tours){

            if(t.getCityName().toLowerCase().contains(word.toLowerCase()))

                searchedTours.add(t);
        }

        Collections.sort(searchedTours, new Tour.Compare());

        return searchedTours;
    }
}
