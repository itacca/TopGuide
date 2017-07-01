package com.topguide.topguide.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Vanja on 30.6.2017..
 */

public class Guide extends Tourist implements Serializable{

    public Guide() {
    }

    public Guide(String name, String lastname, String email, User user, ArrayList<Tour> tours) {
        super(name, lastname, email, user, tours);
    }
}
