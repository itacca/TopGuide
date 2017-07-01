package com.topguide.topguide.model;

import java.io.Serializable;

/**
 * Created by Vanja on 30.6.2017..
 */

public class Comment implements Serializable {

    private String comment;

    public Comment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
