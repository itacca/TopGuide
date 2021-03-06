package com.topguide.topguide.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.dao.UserDao;
import com.topguide.topguide.model.User;

public class MainActivity extends AppCompatActivity {

    private static final int WELCOME_START_CODE = 56;

    private TopGuideApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app = (TopGuideApp) getApplication();

        /*
        Intent intent = new Intent(this, GuideActivity.class);
        startActivityForResult(intent, WELCOME_START_CODE);
        */

        init();
    }

    private void init() {
        // if no user is logged in
        if (app.getUserDao().getCurrentUser() == null) {
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivityForResult(intent, WELCOME_START_CODE);
        } else {
            openActivityForCurrentUser();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == WELCOME_START_CODE) {
            if (resultCode == RESULT_OK) {
                openActivityForCurrentUser();
            }
        }
    }

    private void openActivityForCurrentUser() {
        if (app.getUserDao().getCurrentUser().getRole() == User.Role.GUEST) {
            Intent intent = new Intent(this, UnregisteredActivity.class);
            startActivity(intent);
        } else if (app.getUserDao().getCurrentUser().getRole() == User.Role.TOURIST) {
            Intent intent = new Intent(this, TouristActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, GuideActivity.class);
            startActivity(intent);
        }
    }
}
