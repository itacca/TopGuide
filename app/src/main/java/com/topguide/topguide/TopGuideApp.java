package com.topguide.topguide;

import android.app.Application;

import com.topguide.topguide.dao.PersonDao;
import com.topguide.topguide.dao.UserDao;

/**
 * Created by Igor on 6/27/2017.
 */

public class TopGuideApp extends Application {

    private UserDao userDao;
    private PersonDao personDao;

    @Override
    public void onCreate() {
        super.onCreate();

        userDao = new UserDao();
        personDao = new PersonDao();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public PersonDao getPersonDao() {
        return  personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}
