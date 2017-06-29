package com.topguide.topguide.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.topguide.topguide.R;
import com.topguide.topguide.dao.UserDao;

public class MainActivity extends AppCompatActivity {


    private static final int WELCOME_START_CODE = 56;
    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        // if no user is logged in
        //if (userDao.getCurrentUser() == null) {
            Intent intent = new Intent(this, TouristActivity.class);
            startActivityForResult(intent, WELCOME_START_CODE);
        //} else {

        //}

    }
}
