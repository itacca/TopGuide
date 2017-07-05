package com.topguide.topguide.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.adapter.TourAdapter;
import com.topguide.topguide.dao.TourDao;
import com.topguide.topguide.model.Tour;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.widget.ListView;

import java.util.ArrayList;


public class TouristActivity extends AppCompatActivity {

    EditText tourText;
    Button profileButton;
    Button tourButton;
    ListView listView;
    Tour currentTour;
    TopGuideApp app;

    private static final int DETAILED_TOUR_CODE = 24;
    private static final int TOURIST_PROFILE_CODE = 77;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist);

        init();
    }

    private void init() {
        app = (TopGuideApp) getApplication();

        context = this;

        listView = (ListView) findViewById(R.id.tourslist);
        TourAdapter adapter = new TourAdapter(this, app.getTourDao().getTours());
        listView.setAdapter(adapter);

        tourText = (EditText) findViewById(R.id.edittext);
        profileButton = (Button) findViewById(R.id.profilebutton);
        profileButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TouristActivity.this, TouristProfileActivity.class);
                startActivityForResult(intent, TOURIST_PROFILE_CODE);
            }
        });

        tourButton = (Button) findViewById(R.id.searchToursButton);
        tourButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String word = tourText.getText().toString();
                ArrayList<Tour> searchedTours = app.getTourDao().searchTours(word);
                TourAdapter adapter = new TourAdapter(getBaseContext(), searchedTours);
                listView.setAdapter(adapter);
                //show searched tours
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                currentTour = app.getTourDao().getTours().get(i);

                if(currentTour.getState().askedForStatus().equals("Finished")){

                    //PRIKAZ ZAVRSENE TURE

                }
                else {
                    Intent next = new Intent(TouristActivity.this, DetailedTourActivity.class);
                    next.putExtra("tour", currentTour);
                    startActivityForResult(next, DETAILED_TOUR_CODE);
                }
            }
        });
    }
}
