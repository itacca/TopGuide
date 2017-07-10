package com.topguide.topguide.model.state;

import com.topguide.topguide.model.Tour;

import java.io.Serializable;

/**
 * Created by Vanja on 30.6.2017..
 */

public abstract class State implements Serializable {

    protected Tour tour;

    public State() {
        tour = null;
    }

    public State(Tour t) {
        tour = t;
    }

    public abstract boolean signUpCheck();

    public abstract String askedForStatus();

    public abstract void dateCheckRequested();

    public abstract void stateChangeRequested();

    public abstract String askedForSignUpButton();

    public abstract boolean ratingPossibilityCheck();
}
