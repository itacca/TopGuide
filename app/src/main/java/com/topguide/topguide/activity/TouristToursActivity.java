package com.topguide.topguide.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.adapter.TourAdapter;
import com.topguide.topguide.dao.TourDao;
import com.topguide.topguide.model.Tour;

import java.util.ArrayList;

public class TouristToursActivity extends AppCompatActivity {

    private static final int DETAILED_TOUR_CODE = 215;
    private TopGuideApp app;
    private Tour currentTour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_tours);

        app = (TopGuideApp) getApplication();

        init();
    }

    public void init() {
        ArrayList<Tour> tours = app.getPersonDao().getCurrentTourist().getTours();

        ListView listView = (ListView) findViewById(R.id.touristtourslist);
        TourAdapter adapter = new TourAdapter(this, tours);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                currentTour = app.getTourDao().getTours().get(i);

                Intent next = new Intent(TouristToursActivity.this, DetailedTourActivity.class);
                next.putExtra("tour", currentTour);
                startActivityForResult(next, DETAILED_TOUR_CODE);
            }
        });
    }
}
