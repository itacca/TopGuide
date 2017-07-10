package com.topguide.topguide.model_test.state_test;

import com.topguide.topguide.model.Tour;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Date;

/**
 * Created by Igor on 7/10/2017.
 */

public class ActiveStateTest {
    private static Tour tour;

    @Before
    public void setUpClass() {
        tour = new Tour("a", "a", new Date(), 0);
    }

    @Test
    public void signUpCheckTest() {
        assertTrue(tour.getState().signUpCheck());
    }

    @Test
    public void askedForStatusTest() {
        assertEquals(tour.getState().askedForStatus(), "Active");
    }

    @Test
    public void askedForStatus2() {
        assertNotEquals(tour.getState().askedForStatus(), "Finished");
    }

    @Test
    public void ratingPossibilityCheckTest() {
        assertFalse(tour.getState().ratingPossibilityCheck());
    }

    @Test
    public void ratingPossibilityCheckTest2() {
        assertEquals(false, tour.getState().ratingPossibilityCheck());
    }


}
