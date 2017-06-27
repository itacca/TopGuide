package com.topguide.topguide.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.topguide.topguide.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int LOGIN_START_CODE = 10;
    private static final int REGISTER_START_CODE = 28;
    Button loginBtn;
    Button registerBtn;
    Button guestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();

    }

    private void init() {

        loginBtn = (Button) findViewById(R.id.login_button);
        registerBtn = (Button) findViewById(R.id.register_button);
        guestBtn = (Button) findViewById(R.id.welcome_guest);

        loginBtn.setOnClickListener(WelcomeActivity.this);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.login_button:
                Intent intent = new Intent(this, WelcomeActivity.class);
                startActivityForResult(intent, LOGIN_START_CODE);
                break;
            case R.id.register_button:
                Intent intent2 = new Intent(this, WelcomeActivity.class);
                startActivityForResult(intent2, REGISTER_START_CODE);
                break;
            case R.id.welcome_guest:

                break;
        }
    }
}
