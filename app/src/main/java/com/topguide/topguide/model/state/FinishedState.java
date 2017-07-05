package com.topguide.topguide.model.state;

/**
 * Created by Igor on 7/4/2017.
 */

public class FinishedState extends State {

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

}
