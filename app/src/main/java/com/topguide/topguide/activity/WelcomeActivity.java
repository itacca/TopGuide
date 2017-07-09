package com.topguide.topguide.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.model.User;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int LOGIN_START_CODE = 10;
    private static final int REGISTER_START_CODE = 28;
    private Button loginBtn;
    private Button registerBtn;
    private Button guestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();

    }

    private void init() {

        loginBtn = (Button) findViewById(R.id.welcome_login);
        registerBtn = (Button) findViewById(R.id.welcome_register);
        guestBtn = (Button) findViewById(R.id.welcome_guest);

        loginBtn.setOnClickListener(WelcomeActivity.this);
        registerBtn.setOnClickListener(WelcomeActivity.this);
        guestBtn.setOnClickListener(WelcomeActivity.this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.welcome_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivityForResult(intent, LOGIN_START_CODE);
                break;
            case R.id.welcome_register:
                Intent intent2 = new Intent(this, RegisterActivity.class);
                startActivityForResult(intent2, REGISTER_START_CODE);
                break;
            case R.id.welcome_guest:
                TopGuideApp app = (TopGuideApp) getApplicationContext();
                app.getUserDao().setCurrentUser(new User());
                Intent intent3 = new Intent();
                setResult(RESULT_OK, intent3);
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOGIN_START_CODE) {
            if (resultCode == RESULT_OK) {
                if (data.getExtras().getBoolean("successful")) {
                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        } else if (requestCode == REGISTER_START_CODE) {
            if (resultCode == RESULT_OK) {
                if (data.getExtras().getBoolean("successful")) {
                    Intent intent2 = new Intent();
                    setResult(RESULT_OK, intent2);
                    finish();
                }
            }
        }
    }

    @Override
    public void onBackPressed() {

    }
}
