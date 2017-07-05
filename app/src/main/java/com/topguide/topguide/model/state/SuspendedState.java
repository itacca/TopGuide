package com.topguide.topguide.model.state;

/**
 * Created by Igor on 7/4/2017.
 */

public class SuspendedState extends State {

    @Override
    public boolean signUpCheck() {
        return tour.returnNegativeStatus();
    }

    @Override
    public String askedForStatus() {
        return tour.returnStatusSuspended();
    }
}
