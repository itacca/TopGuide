package com.topguide.topguide.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private Button switchButton;
    private Button toursButton;

    private TopGuideApp app;
    private Context context;

    private static final int GUIDE_TOURS_CODE = 12;
    private static final int TOURIST_PROFILE_CODE = 444;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_profile);

        context = this;
        init();
    }

    public void init(){
        app = (TopGuideApp) getApplication();

        final Guide guide = app.getPersonDao().getCurrentGuide();

        setUpButtons(guide);
        setUpListeners(guide);
    }

    private void setUpButtons(Guide currentGuide){
        usernameButton = (Button) findViewById(R.id.usernamebuttonguide);
        passwordButton = (Button) findViewById(R.id.passwordbuttonguide);
        firstNameButton = (Button) findViewById(R.id.namebuttonguide);
        lastNameButton = (Button) findViewById(R.id.lastnamebuttonguide);
        emailButton = (Button) findViewById(R.id.emailbuttonguide);
        switchButton = (Button) findViewById(R.id.switchprfilebuttonguide);
        toursButton = (Button) findViewById(R.id.seetoursbuttonguide);

        Guide guide = app.getPersonDao().getCurrentGuide();

        usernameButton.setText(currentGuide.getUser().getUsername());
        passwordButton.setText(currentGuide.getUser().getPassword());
        firstNameButton.setText(currentGuide.getName());
        lastNameButton.setText(currentGuide.getLastname());
        emailButton.setText(currentGuide.getEmail());
    }

    private void setUpListeners(final Guide currentGuide){
        final LayoutInflater inflater = this.getLayoutInflater();

        usernameButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final View dialogView = inflater.inflate(R.layout.dialog_change_data, null);
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

                dialogBuilder.setTitle("Change username");
                dialogBuilder.setView(dialogView);

                final TextView text1 = (TextView) dialogView.findViewById(R.id.text1_id);

                text1.setText("\nEnter new username: ");

                final EditText newUsername = (EditText) dialogView.findViewById(R.id.dialog_new_info);
                newUsername.setHint(currentGuide.getUser().getUsername());

                dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String input = newUsername.getText().toString();
                        if(app.getUserDao().userExists(input)){
                            Toast.makeText(context, "That username already exists!\nPlease enter a new one.", Toast.LENGTH_SHORT).show();
                        } else{
                            currentGuide.getUser().setUsername(input);
                            Toast.makeText(context, "Username successfuly changed to \n" + input + "!", Toast.LENGTH_SHORT).show();
                            usernameButton.setText(input);
                        }
                    }
                });

                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog dialog = dialogBuilder.create();

                dialog.show();
            }
        });

        passwordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View dialogView = inflater.inflate(R.layout.dialog_change_data, null);
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

                dialogBuilder.setTitle("Change password");
                dialogBuilder.setView(dialogView);

                final TextView text1 = (TextView) dialogView.findViewById(R.id.text1_id);

                text1.setText("\nEnter new password: ");

                final EditText newPassword = (EditText) dialogView.findViewById(R.id.dialog_new_info);
                newPassword.setHint(currentGuide.getUser().getPassword());

                dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String input = newPassword.getText().toString();
                        currentGuide.getUser().setPassword(input);
                        Toast.makeText(context, "Password successfuly changed to \n" + input + "!", Toast.LENGTH_SHORT).show();
                        passwordButton.setText(input);
                    }
                });

                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog dialog = dialogBuilder.create();

                dialog.show();
            }
        });

        firstNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View dialogView = inflater.inflate(R.layout.dialog_change_data, null);
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

                dialogBuilder.setTitle("Change first name:");
                dialogBuilder.setView(dialogView);

                final TextView text1 = (TextView) dialogView.findViewById(R.id.text1_id);

                text1.setText("\nEnter new first name: ");

                final EditText newName = (EditText) dialogView.findViewById(R.id.dialog_new_info);
                newName.setHint(currentGuide.getName());

                dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String input = newName.getText().toString();
                        String output = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
                        if(output.matches(".*\\d+.*")){
                            Toast.makeText(context, "First name can't contain numbers!", Toast.LENGTH_SHORT).show();
                        } else{
                            currentGuide.setName(output);
                            Toast.makeText(context, "First name successfuly changed to \n" + output + "!", Toast.LENGTH_SHORT).show();
                            firstNameButton.setText(output);
                        }
                    }
                });

                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog dialog = dialogBuilder.create();

                dialog.show();
            }
        });

        lastNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View dialogView = inflater.inflate(R.layout.dialog_change_data, null);
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

                dialogBuilder.setTitle("Change last name:");
                dialogBuilder.setView(dialogView);

                final TextView text1 = (TextView) dialogView.findViewById(R.id.text1_id);

                text1.setText("\nEnter new last name: ");

                final EditText newLastName = (EditText) dialogView.findViewById(R.id.dialog_new_info);
                newLastName.setHint(currentGuide.getLastname());

                dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String input = newLastName.getText().toString();
                        String output = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
                        if(output.matches(".*\\d+.*")){
                            Toast.makeText(context, "Last name can't contain numbers!", Toast.LENGTH_SHORT).show();
                        } else {
                            currentGuide.setLastname(output);
                            Toast.makeText(context, "Last name successfuly changed to \n" + output + "!", Toast.LENGTH_SHORT).show();
                            lastNameButton.setText(output);
                        }
                    }
                });

                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog dialog = dialogBuilder.create();

                dialog.show();
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View dialogView = inflater.inflate(R.layout.dialog_change_data, null);
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

                dialogBuilder.setTitle("Change email:");
                dialogBuilder.setView(dialogView);

                final TextView text1 = (TextView) dialogView.findViewById(R.id.text1_id);

                text1.setText("\nEnter new email: ");

                final EditText newEmail = (EditText) dialogView.findViewById(R.id.dialog_new_info);
                newEmail.setHint(currentGuide.getEmail());

                dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String input = newEmail.getText().toString();
                        if(!input.contains("@") || !input.endsWith(".com")){
                            Toast.makeText(context,"Wrong email format entered.\nPlease enter a correct email!", Toast.LENGTH_SHORT).show();
                        } else{
                            currentGuide.setEmail(input);
                            Toast.makeText(context,"Email successfuly changed to \n" + input + "!", Toast.LENGTH_SHORT).show();
                            emailButton.setText(input);
                        }
                    }
                });

                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog dialog = dialogBuilder.create();

                dialog.show();
            }
        });

        toursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GuideToursActivity.class);
                startActivityForResult(intent, GUIDE_TOURS_CODE);
            }
        });

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, TouristProfileActivity.class);
                startActivityForResult(intent, TOURIST_PROFILE_CODE);
            }
        });
    }
}
