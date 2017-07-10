package com.topguide.topguide.model.state;

import com.topguide.topguide.model.Tour;

/**
 * Created by Igor on 7/4/2017.
 */

public class ActiveState extends State {

    public ActiveState() {
        super();
    }

    public ActiveState(Tour t) {
        super(t);
    }

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
            tour.changeState(new FinishedState(tour));
        }
    }

    @Override
    public void stateChangeRequested() {
        tour.changeState(new SuspendedState(tour));
    }

    @Override
    public String askedForSignUpButton() {
        return tour.returnSignUpLabelActive();
    }

    @Override
    public boolean ratingPossibilityCheck() {
        return false;
    }
}
