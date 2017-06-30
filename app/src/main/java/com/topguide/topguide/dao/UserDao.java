package com.topguide.topguide.dao;

import com.topguide.topguide.model.User;

import java.util.ArrayList;

/**
 * Created by Igor on 6/20/2017.
 */

public class UserDao {

    private User currentUser;
    private ArrayList<User> users;

    public UserDao() {
        init();
    }

    private void init() {
        currentUser = null;
        users = null;
    }

    public void readUsers() {

    }

    public boolean validateUser(String username, String password) {

        return true;
    }

    public boolean userExists(String username) {
        return false;
    }

    public void writeUser(String username, String password) {

    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}

