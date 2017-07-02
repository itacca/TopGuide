package com.topguide.topguide.dao;

import android.content.Context;

import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.model.User;

import java.util.ArrayList;

/**
 * Created by Igor on 6/20/2017.
 */

public class UserDao {

    private User currentUser;
    private ArrayList<User> users;
    private TopGuideApp app;

    public UserDao(TopGuideApp app) {
        currentUser = null;
        users = new ArrayList<>();
        this.app = app;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User u) {
        users.add(u);
    }

    public boolean validateUser(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                if (u.getPassword().equals(password)) {
                    setCurrentUser(u);
                    app.getPersonDao().setUpCurrentTourist(u.getUsername());
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean userExists(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}

