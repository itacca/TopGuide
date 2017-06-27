package com.topguide.topguide;

import android.app.Application;

import com.topguide.topguide.dao.UserDao;

/**
 * Created by Igor on 6/27/2017.
 */

public class TopGuideApp extends Application {

    private UserDao userDao;

    @Override
    public void onCreate() {
        super.onCreate();

        userDao = new UserDao();
    }


}
