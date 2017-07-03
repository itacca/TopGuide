package com.topguide.topguide.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.model.Tour;
import com.topguide.topguide.model.Tourist;

import java.text.SimpleDateFormat;

public class DetailedTourActivity extends AppCompatActivity {

    Tour currentTour;
    TopGuideApp app;
    TextView tourName;
    TextView placeName;
    TextView dateAndTime;
    TextView tourRate;
    TextView guideName;
    TextView guideRate;
    TextView tourPrice;
    TextView tourStatus;
    TextView tourDescription;
    Button signUpButton;
    boolean signed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_tour);

        init();
    }

    public void init() {


        app = (TopGuideApp) getApplication();
        currentTour = (Tour) this.getIntent().getExtras().getSerializable("tour");

        tourName = (TextView) findViewById(R.id.tourname);
        tourName.setText(currentTour.getName());

        placeName = (TextView) findViewById(R.id.placename);
        placeName.setText(currentTour.getPlaceName().getName());

        dateAndTime = (TextView) findViewById(R.id.dateandtime);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
        dateAndTime.setText(formatter.format(currentTour.getStartDate()));

        tourRate = (TextView) findViewById(R.id.ratevalue);
        tourRate.setText(String.format("%.2f", currentTour.getRate()));

        guideName = (TextView) findViewById(R.id.guidename);
        guideName.setText(currentTour.getGuide().getName() + " " + currentTour.getGuide().getLastname());

        guideRate = (TextView) findViewById(R.id.guideratevalue);
        guideRate.setText(String.format("%.2f", currentTour.getRate()));

        tourPrice = (TextView) findViewById(R.id.tourprice);
        tourPrice.setText(String.format("%.2f", currentTour.getPrice().getPrice()) + " dinara");

        tourStatus = (TextView) findViewById(R.id.tourstatus);
        tourStatus.setText("AKTIVNO!!!");
        //stanje, razlicita boja, zavisi od stanja ,crvena za neaktivno, zuta za susp, zeleno za aktivno

        tourDescription = (TextView) findViewById(R.id.tourdescription);
        tourDescription.setText(currentTour.getDescription());

        signUpButton = (Button) findViewById(R.id.signupbutton);

        setUpButtonSettings();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(signed)

                    app.getPersonDao().getCurrentTourist().signOutOfTour(currentTour);

                else

                    app.getPersonDao().getCurrentTourist().signUpForTour(currentTour);


                setUpButtonSettings();
            }
        });
    }

    private void setUpButtonSettings() {
        signUpButton.setText("Sign up for tour");

        signed = false;

        signed = app.getPersonDao().getCurrentTourist().checkAttendenceOnTour(currentTour);

        if (signed) {
            signUpButton.setText("Sign out of tour");
        }

    }
}
