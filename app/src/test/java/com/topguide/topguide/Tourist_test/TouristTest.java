package com.topguide.topguide.Tourist_test;

import com.topguide.topguide.model.Tour;
import com.topguide.topguide.model.Tourist;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by Vanja on 9.7.2017..
 */

public class TouristTest {
    private static Tourist tourist;
    private static Tour tour;
    private static ArrayList<Tour> tours;

    @Before
    public void setUpClass(){

        tourist = new Tourist();
        tour = new Tour();
        tours = new ArrayList<>();
    }

    @Test
    public void signUpForTourTrueTest() {

        tours.add(tour);
        tourist.signUpForTour(tour);

        assertEquals(tourist.getTours(), tours);
    }

    @Test
    public void signUpForTourFalseTest() {

        tourist.signUpForTour(tour);

        assertNotEquals(tourist.getTours(), tours);
    }

    @Test
    public void signOutOfTourTrueTest() {

        tourist.getTours().add(tour);
        tourist.signOutOfTour(tour);

        assertEquals(tourist.getTours(), tours);
    }

    @Test
    public void signOutOfTourFalseTest() {

        tourist.getTours().add(tour);
        tours.add(tour);
        tourist.signOutOfTour(tour);

        assertNotEquals(tourist.getTours(), tours);
    }

    @Test
    public void checkAttendenceOnTourTrueTest() {

        tourist.getTours().add(tour);

        assertTrue(tourist.checkAttendenceOnTour(tour));
    }

    @Test
    public void checkAttendenceOnTourFalseTest() {

        assertFalse(tourist.checkAttendenceOnTour(tour));
    }
}