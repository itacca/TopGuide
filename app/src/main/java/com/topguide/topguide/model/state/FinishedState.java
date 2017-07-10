package com.topguide.topguide.model.state;

import com.topguide.topguide.model.Tour;

/**
 * Created by Igor on 7/4/2017.
 */

public class FinishedState extends State {


    public FinishedState() {
        super();
    }

    public FinishedState(Tour t) {
        super(t);
    }

    @Override
    public boolean signUpCheck() {
        return tour.returnNegativeStatus();
    }

    @Override
    public String askedForStatus() {
        return tour.returnStatusFinished();
    }

    @Override
    public void dateCheckRequested() {

    }

    @Override
    public void stateChangeRequested() {

    }

    @Override
    public String askedForSignUpButton() {
        return tour.returnSignUpLabelFinished();
    }

    @Override
    public boolean ratingPossibilityCheck() {
        return true;
    }

}
