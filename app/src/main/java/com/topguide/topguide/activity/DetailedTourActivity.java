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

    private Tour currentTour;
    private TopGuideApp app;
    private TextView tourName;
    private TextView placeName;
    private TextView dateAndTime;
    private TextView tourRate;
    private TextView guideName;
    private TextView guideRate;
    private TextView tourPrice;
    private TextView tourStatus;
    private TextView tourDescription;
    private Button signUpButton;
    private boolean signed;

    private static final int RATE_TOUR_CODE = 323;

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

        tourDescription = (TextView) findViewById(R.id.tourdescription);
        tourDescription.setText(currentTour.getDescription());

        signUpButton = (Button) findViewById(R.id.signupbutton);

        checkStartDate();

        setUpButtonSettings();

        setUpStatus();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (currentTour.getState().askedForStatus().equals(currentTour.getSUSPENDED())){

                    if (signed){

                        Intent next = new Intent(DetailedTourActivity.this, RateTourActivity.class);
                        next.putExtra("finishedtour", currentTour);
                        startActivityForResult(next, RATE_TOUR_CODE);
                    }
                }

                else {
                    if (signed)

                        app.getPersonDao().getCurrentTourist().signOutOfTour(currentTour);

                    else

                        app.getPersonDao().getCurrentTourist().signUpForTour(currentTour);

                }
                setUpButtonSettings();
            }
        });
    }

    private void checkStartDate() {
        currentTour.getState().dateCheckRequested();
    }

    private void setUpStatus() {
        tourStatus.setText(currentTour.getState().askedForStatus());
    }

    private void setUpButtonSettings() {

        signUpButton.setClickable(false);
        signed = false;

        signUpButton.setText(currentTour.getState().askedForSignUpButton());

        if (currentTour.getState().ratingPossibilityCheck()) {
            for(Tour t : app.getPersonDao().getCurrentTourist().getTours()){
                if(currentTour.getName().equals(t.getName())){

                    signUpButton.setText("Submit rate(s)/comment");
                    signUpButton.setClickable(true);
                    signed = true;
                    break;
                }
            }
        }

        if(currentTour.getState().askedForStatus().equals(currentTour.getACTIVE())){
            signed = false;

            signed = app.getPersonDao().getCurrentTourist().checkAttendenceOnTour(currentTour);

            if (signed) {
                signUpButton.setText("Sign out of tour");
            }

            if (!performSignUpCheck()) {
                signUpButton.setClickable(false);
            }
        }
    }

    private boolean performSignUpCheck() {

        return currentTour.getState().signUpCheck();
    }
}
