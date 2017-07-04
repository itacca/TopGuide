package com.topguide.topguide.model.state;

/**
 * Created by Igor on 7/4/2017.
 */

public class ActiveState extends State {

    private static final String ACTIVE = "Active" ;

    @Override
    public boolean signUpCheck() {
        return tour.returnPositiveStatus();
    }

    @Override
    public String askedForStatus() {
        return ACTIVE;
    }
}
