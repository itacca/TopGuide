package com.topguide.topguide.model.state;

/**
 * Created by Igor on 7/4/2017.
 */

public class FinishedState extends State {

    private static final String FINISHED = "Finished";

    @Override
    public boolean signUpCheck() {
        return tour.returnNegativeStatus();
    }

    @Override
    public String askedForStatus() {
        return FINISHED;
    }
}
