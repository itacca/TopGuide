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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;

    private EditText password;

    private EditText name;

    private EditText lastname;

    private EditText email;

    private Button register;

    private TopGuideApp app;

    private boolean isSuccessful = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        app = (TopGuideApp) getApplication();

        init();
    }

    private void init() {

        username = (EditText) findViewById(R.id.username_register);
        password = (EditText) findViewById(R.id.password_register);
        name = (EditText) findViewById(R.id.name_register);
        lastname = (EditText) findViewById(R.id.lastname_register);
        email = (EditText) findViewById(R.id.email_register);

        register = (Button) findViewById(R.id.register_button);

        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String textUsername = username.getText().toString();
        String textPassword = password.getText().toString();
        String textName = name.getText().toString();
        String textLastName = lastname.getText().toString();
        String textEmail = email.getText().toString();

        if(textUsername.matches("") || textPassword.matches("") || textName.matches("") || textLastName.matches("") || textEmail.matches("")) {
            Context context = getApplicationContext();
            CharSequence text = "Fields should not be empty!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }

        if (app.getUserDao().userExists(textUsername)) {
            Context con = getApplicationContext();
            CharSequence text = "The user with the same username already exists!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(con, text, duration);
            toast.show();
            return;
        }

        if(!textEmail.contains("@") || !textEmail.endsWith(".com")){
            Toast.makeText(RegisterActivity.this,"Wrong email format entered.\nPlease enter a correct email!", Toast.LENGTH_SHORT).show();
            return;
        }

        app.getPersonDao().writePerson(textUsername, textPassword, textName, textLastName, textEmail, 0);

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
