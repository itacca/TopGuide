package com.topguide.topguide.model;

import java.io.Serializable;

/**
 * Created by Vanja on 3.7.2017..
 */

public class Place implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Place() {
    }

    public Place(String name) {
        this.name = name;
    }
}
