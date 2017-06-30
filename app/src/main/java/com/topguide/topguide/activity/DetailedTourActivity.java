package com.topguide.topguide.activity;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.model.Tour;

import java.text.SimpleDateFormat;

public class DetailedTourActivity extends AppCompatActivity {

    Tour currentTour;
    TopGuideApp app;
    TextView tourName;
    TextView cityName;
    TextView dateAndTime;
    TextView tourRate;
    TextView guideName;
    TextView guideRate;
    TextView tourPrice;
    TextView tourStatus;
    TextView tourDescription;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_tour);

        init();
    }

    public void init() {

/*
        app = (TopGuideApp) getApplication();
        currentTour = (Tour) this.getIntent().getExtras().getSerializable("tour");

        tourName = (TextView) findViewById(R.id.tourname);
        tourName.setText(currentTour.getName());

        cityName = (TextView) findViewById(R.id.cityname);
        cityName.setText(currentTour.getCityName());

        dateAndTime = (TextView) findViewById(R.id.dateandtime);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm");

        dateAndTime.setText(formatter.format(currentTour.getStartDate()));

        tourRate = (TextView) findViewById(R.id.ratelabel);
        tourRate.setText(String.format("%.2f", currentTour.getRate()));

        guideName = (TextView) findViewById(R.id.guidename);
        guideName.setText(currentTour.getGuide().getName() + " " + currentTour.getGuide().getLastname());

        guideRate = (TextView) findViewById(R.id.guideratevalue);
        guideRate.setText(String.format("%.2f", currentTour.getRate()));

        tourPrice = (TextView) findViewById(R.id.tourprice);
        tourPrice.setText(String.format("%.2f", currentTour.getPrice().getPrice()) + " dinara");

        tourPrice = (TextView) findViewById(R.id.tourprice);
        tourPrice.setText(String.format("%.2f", currentTour.getPrice().getPrice()) + " dinara");

        tourStatus = (TextView) findViewById(R.id.tourstatus);
        tourStatus.setText("AKTIVNO!!!");
        //stanje, razlicita boja, zavisi od stanja ,crvena za neaktivno, zuta za susp, zeleno za aktivno

        tourDescription = (TextView) findViewById(R.id.tourdescription);
        tourDescription.setText(currentTour.getDescription());

        signUpButton = (Button) findViewById(R.id.searchToursButton);
        signUpButton.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
*/
        /**
         * if prijavljen na turu then DUGME POSTAJE ODJAVNO DUGME
         *
         * ELSE PRIJAVA (DOLE)
         */

/*
        signUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //PRIJAVA NA TURU
            }
        });*/
    }
}
