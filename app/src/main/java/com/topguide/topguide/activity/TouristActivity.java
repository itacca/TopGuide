package com.topguide.topguide.activity;

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
    int DETAILED_TOUR_CODE = 18;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist);

        init();
    }

    private void init() {
        app = (TopGuideApp) getApplication();

        listView = (ListView) findViewById(R.id.tourslist);
        TourAdapter adapter = new TourAdapter(this, app.getTourDao().getTours());
        listView.setAdapter(adapter);

        tourText = (EditText) findViewById(R.id.edittext);
        profileButton = (Button) findViewById(R.id.profilebutton);
        profileButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                //enter my profile
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


                Intent articleList = new Intent(getBaseContext(), DetailedTourActivity.class);
                articleList.putExtra("tour",currentTour);
                startActivityForResult(articleList, DETAILED_TOUR_CODE);
            }
        });
    }
}
