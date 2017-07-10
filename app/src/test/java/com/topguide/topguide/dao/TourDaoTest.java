package com.topguide.topguide.dao;

import android.content.SyncStatusObserver;

import com.topguide.topguide.model.Guide;
import com.topguide.topguide.model.Tour;
import com.topguide.topguide.model.User;

import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by test on 7/9/2017.
 */

public class TourDaoTest {
    private static TourDao tourDao;
    private static ArrayList<Tour> tours;

    @BeforeClass
    public static void setUpClass(){
        tourDao = new TourDao();
        tours = tourDao.getTours();

        for (Tour t: tours){
            if (t.getPlaceName().getName().contains("ad")){
                t.setGuide(new Guide("Ana", "BanicVodic", "anab@gmail.com", new User("bana", "12345", 1)));
            } else{
                t.setGuide(new Guide("Ana", "CanicVodic", "anab@gmail.com", new User("cana", "12345", 1)));
            }
        }
    }

    @Test
    public void searchToursTest(){

        ArrayList<Tour> testTours = new ArrayList<>();


        testTours.add(new Tour("Obilazak restorana","Novi Sad", tours.get(0).getStartDate()));
        testTours.add(new Tour("Obilazak muzeja","Novi Sad", tours.get(1).getStartDate()));
        testTours.add(new Tour("All-round obilazak","Beograd", tours.get(2).getStartDate()));
        testTours.add(new Tour("Obilazak znamenitosti","Beograd",tours.get(3).getStartDate()));

        ArrayList<Tour> retTours = tourDao.searchTours("ad");


        assertTrue(testTours.equals(retTours));
    }

    @Test
    public void searchToursTestFalse(){

        ArrayList<Tour> testTours = new ArrayList<>();

        testTours.add(new Tour("All-round obilazak","Beograd", tours.get(2).getStartDate()));
        testTours.add(new Tour("Obilazak znamenitosti","Beograd",tours.get(3).getStartDate()));

        ArrayList<Tour> retTours = tourDao.searchTours("ad");


        assertFalse(testTours.equals(retTours));
    }

    @Test
    public void getGuideToursTestTrue(){

        ArrayList<Tour> testTours = new ArrayList<>();

        testTours.add(new Tour("Obilazak restorana","Novi Sad", new Date()));
        testTours.add(new Tour("Obilazak muzeja","Novi Sad", new Date()));
        testTours.add(new Tour("All-round obilazak","Beograd", new Date()));
        testTours.add(new Tour("Obilazak znamenitosti","Beograd",new Date()));

        ArrayList<Tour> retTours = tourDao.getGuideTours("bana");

        assertTrue(testTours.equals(retTours));
    }

    @Test
    public void getGuideToursTestFalse(){

        ArrayList<Tour> testTours = new ArrayList<>();

        testTours.add(new Tour("Obilazak restorana","Novi Sad", new Date()));
        testTours.add(new Tour("Obilazak znamenitosti","Beograd",new Date()));

        ArrayList<Tour> retTours = tourDao.getGuideTours("bana");

        assertFalse(testTours.equals(retTours));
    }

    @Test
    public void searchToursTestUnique(){

        ArrayList<Tour> testTours = new ArrayList<>();

        testTours.add(new Tour("Brza tura po gradu","Nis",new Date()));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d  = new Date();
        try {
            d = sdf.parse("21/12/2019");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        testTours.add(new Tour("Obilazak parkova","Nis",d));

        ArrayList<Tour> retTours = tourDao.searchTours("Nis");

        assertTrue(testTours.equals(retTours));
    }
}