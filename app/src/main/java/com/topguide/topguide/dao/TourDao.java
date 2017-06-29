package com.topguide.topguide.dao;
import com.topguide.topguide.model.Tour;
import java.util.ArrayList;
import java.util.Date;

public class TourDao {

    private ArrayList<Tour> tours;

    public TourDao() {
        tours = new ArrayList<Tour>();
        tours.add(new Tour("A","1", new Date()));
        tours.add(new Tour("B","2",new Date()));
        tours.add(new Tour("C","3",new Date()));
    }

    public ArrayList<Tour> getTours() {

        return tours;
    }

    public ArrayList<Tour> searchTours(String word) {

        ArrayList<Tour> searchedTours = new ArrayList<>();

        for(Tour t : tours){

            if(t.getName().toLowerCase().contains(word.toLowerCase()))

                searchedTours.add(t);
        }

        return searchedTours;
    }
}
