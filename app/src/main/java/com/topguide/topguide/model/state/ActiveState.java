package com.topguide.topguide.model.state;

/**
 * Created by Igor on 7/4/2017.
 */

public class ActiveState extends State {

    @Override
    public boolean signUpCheck() {
        return tour.returnPositiveStatus();
    }

    @Override
    public String askedForStatus() {
        return tour.returnStatusAcitve();
    }

    @Override
    public void dateCheckRequested() {
        if (!tour.checkStartDate()) {
            tour.changeState(new FinishedState());
        }
    }
}
