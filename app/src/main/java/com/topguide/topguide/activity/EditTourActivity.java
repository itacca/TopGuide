package com.topguide.topguide.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.model.Tour;

public class EditTourActivity extends AppCompatActivity {

    private TopGuideApp app;
    private TextView tourName;
    private Button placeName;
    private Button dateAndTime;
    private Button rating;
    private Button tourPrice;
    private Button tourStatus;
    private Button tourDescription;
    private Button changeState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tour);

        app = (TopGuideApp) getApplication();

        init();
    }

    private void init() {
        Tour currentTour = (Tour) this.getIntent().getExtras().getSerializable("tour");

        makeBinds();
        setTourName(currentTour);

        checkStartDate(currentTour);

        setButtonLabels(currentTour);
        setListeners(currentTour);


    }

    private void checkStartDate(Tour currentTour) {
        currentTour.getState().dateCheckRequested();
    }

    private void setButtonLabels(Tour currentTour) {
        placeName.setText(currentTour.getPlaceName().getName());
        dateAndTime.setText(currentTour.getStartDate().toString());
        rating.setText(Double.toString(currentTour.getRate()));
        tourPrice.setText(Double.toString(currentTour.getPrice().getPrice()) + " euros");
        tourStatus.setText(currentTour.getState().askedForStatus());
    }

    private void setListeners(Tour currentTour) {

        placeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dateAndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tourPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tourDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        changeState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setTourName(Tour currentTour) {
        tourName.setText(currentTour.getName());
    }

    private void makeBinds() {
        tourName = (TextView) findViewById(R.id.edit_tour_name);
        placeName = (Button) findViewById(R.id.edit_place);
        dateAndTime = (Button) findViewById(R.id.edit_date);
        rating = (Button) findViewById(R.id.edit_rating);
        tourPrice = (Button) findViewById(R.id.edit_price);
        tourStatus = (Button) findViewById(R.id.edit_status);
        tourDescription = (Button) findViewById(R.id.edit_description);
        changeState = (Button) findViewById(R.id.edit_change_state);
    }
}
