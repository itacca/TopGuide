package com.topguide.topguide.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.model.Tourist;
import com.topguide.topguide.model.User;

public class TouristProfileActivity extends AppCompatActivity {

    private Button usernameButton;
    private Button passwordButton;
    private Button firstNameButton;
    private Button lastNameButton;
    private Button emailButton;
    private Button toursButton;
    private Button becomeGuideButton;

    private TopGuideApp app;

    private static final int TOURIST_TOURS_CODE = 77;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_profile);

        init();
    }

    public void init(){
        app = (TopGuideApp) getApplication();

        usernameButton = (Button) findViewById(R.id.usernamebuttontourist);
        passwordButton = (Button) findViewById(R.id.passwordbuttontourist);
        firstNameButton = (Button) findViewById(R.id.namebuttontourist);
        lastNameButton = (Button) findViewById(R.id.lastnamebuttontourist);
        emailButton = (Button) findViewById(R.id.emailbuttontourist);

        toursButton = (Button) findViewById(R.id.toursbuttontourist);

        Tourist tourist = app.getPersonDao().getCurrentTourist();

        usernameButton.setText(tourist.getUser().getUsername());
        passwordButton.setText(tourist.getUser().getPassword());
        firstNameButton.setText(tourist.getName());
        lastNameButton.setText(tourist.getLastname());
        emailButton.setText(tourist.getEmail());


        toursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TouristProfileActivity.this, TouristToursActivity.class);
                startActivityForResult(intent, TOURIST_TOURS_CODE);
            }
        });

/*        becomeGuideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }
}
