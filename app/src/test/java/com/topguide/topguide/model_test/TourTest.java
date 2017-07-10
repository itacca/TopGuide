package com.topguide.topguide.model_test;

import com.topguide.topguide.model.Rate;
import com.topguide.topguide.model.Tour;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Igor on 7/10/2017.
 */

public class TourTest {

    private static Tour tour;

    @Before
    public void setUpClass() {
        tour = new Tour("a", "a", new Date(), 0);
    }


    @Test
    public void calculateRateTest(){
        assertTrue(tour.calculateRate(new Rate(5.0)) - 5.0 < 0.1 );
    }

    @Test
    public void calculateRateTest2() {
        assertTrue(tour.calculateRate(new Rate(3.0)) - 4.0 < 0.1);
    }

    @Test
    public void checkStartDateTest() {
        assertFalse(tour.checkStartDate());
    }

    @Test
    public void checkStartDateTest2() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
        Date testDate = null;
        try {
            testDate = sdf.parse("12.12.2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tour.setStartDate(testDate);
        assertTrue(tour.checkStartDate());
    }
}
