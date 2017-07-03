package com.topguide.topguide.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.model.Guide;
import com.topguide.topguide.model.Tourist;
import com.topguide.topguide.model.User;

public class GuideProfileActivity extends AppCompatActivity {

    private Button usernameButton;
    private Button passwordButton;
    private Button firstNameButton;
    private Button lastNameButton;
    private Button emailButton;

    private Button toursButton;

    private TopGuideApp app;
    private Context context;

    private static final int GUIDE_TOURS_CODE = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_profile);

        context = this;
        init();
    }

    public void init(){
        app = (TopGuideApp) getApplication();

        usernameButton = (Button) findViewById(R.id.usernamebuttonguide);
        passwordButton = (Button) findViewById(R.id.passwordbuttonguide);
        firstNameButton = (Button) findViewById(R.id.namebuttonguide);
        lastNameButton = (Button) findViewById(R.id.lastnamebuttonguide);
        emailButton = (Button) findViewById(R.id.emailbuttonguide);

        toursButton = (Button) findViewById(R.id.toursbuttonguide);

        Guide guide = app.getPersonDao().getCurrentGuide();

        usernameButton.setText(guide.getUser().getUsername());
        passwordButton.setText(guide.getUser().getPassword());
        firstNameButton.setText(guide.getName());
        lastNameButton.setText(guide.getLastname());
        emailButton.setText(guide.getEmail());


        toursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GuideToursActivity.class);
                startActivityForResult(intent, GUIDE_TOURS_CODE);
            }
        });
    }
}
