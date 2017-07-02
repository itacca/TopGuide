package com.topguide.topguide.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{


    private EditText username;

    private EditText password;

    private Button login;

    private TopGuideApp app;

    private boolean isSuccessful = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        app = (TopGuideApp) getApplication();

        init();
    }

    private void init() {

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.login_button);

        login.setOnClickListener(LoginActivity.this);

    }

    @Override
    public void onClick(View view) {

        String textUsername = username.getText().toString();
        String textPassword = password.getText().toString();

        if(textUsername.matches("") || textPassword.matches("")) {
            Context context = getApplicationContext();
            CharSequence text = "Fields should not be empty!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }

        if (!app.getUserDao().validateUser(textUsername, textPassword)) {
            Context context = getApplicationContext();
            CharSequence text = "You entered wrong username or/and password!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }

        isSuccessful = true;

        setUpResult();
    }


    @Override
    public void onBackPressed() {
        setUpResult();
        super.onBackPressed();
    }

    private void setUpResult() {
        Intent intent = new Intent();
        intent.putExtra("successful", isSuccessful);
        setResult(RESULT_OK, intent);
        finish();
    }
}
