package com.topguide.topguide.dao;
import com.topguide.topguide.model.Tour;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class TourDao {

    private ArrayList<Tour> tours;

    public TourDao() {
        tours = new ArrayList<Tour>();
        tours.add(new Tour("A","1", new Date()));
        tours.add(new Tour("AAa","1", new Date(),2));
        tours.add(new Tour("Aa","1", new Date()));
        tours.add(new Tour("B","2",new Date()));
        tours.add(new Tour("C","3",new Date()));
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
