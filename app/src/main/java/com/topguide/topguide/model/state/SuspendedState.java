package com.topguide.topguide.model.state;

import com.topguide.topguide.model.Tour;

/**
 * Created by Igor on 7/4/2017.
 */

public class SuspendedState extends State {


    public SuspendedState() {
        super();
    }

    public SuspendedState(Tour t) {
        super(t);
    }

    @Override
    public boolean signUpCheck() {
        return tour.returnNegativeStatus();
    }

    @Override
    public String askedForStatus() {
        return tour.returnStatusSuspended();
    }

    @Override
    public void dateCheckRequested() {
        if (!tour.checkStartDate()) {
            tour.changeState(new FinishedState(tour));
        }
    }

    @Override
    public void stateChangeRequested() {
        tour.changeState(new SuspendedState(tour));
    }

    @Override
    public String askedForSignUpButton() {
        return tour.returnSignUpLabelSuspended();
    }

    @Override
    public boolean ratingPossibilityCheck() {
        return false;
    }
}
