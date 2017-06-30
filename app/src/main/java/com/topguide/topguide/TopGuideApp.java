package com.topguide.topguide;

import android.app.Application;
import android.content.Intent;

import com.topguide.topguide.dao.PersonDao;
import com.topguide.topguide.dao.TourDao;
import com.topguide.topguide.dao.UserDao;

/**
 * Created by Igor on 6/27/2017.
 */

public class TopGuideApp extends Application {

    private UserDao userDao;
    private PersonDao personDao;
    private TourDao tourDao;

    @Override
    public void onCreate() {
        super.onCreate();

        userDao = new UserDao();
        personDao = new PersonDao(userDao);
        tourDao = new TourDao();
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

    public TourDao getTourDao() { return  tourDao; }

    public void setTourDao(TourDao tourDao) {
        this.tourDao = tourDao;
    }
}
