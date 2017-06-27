package com.topguide.topguide.dao;

import com.topguide.topguide.model.User;

/**
 * Created by Igor on 6/20/2017.
 */

public class UserDao {

    private User currentUser;

    public UserDao() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
