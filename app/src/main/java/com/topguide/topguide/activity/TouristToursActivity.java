package com.topguide.topguide.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.adapter.TourAdapter;
import com.topguide.topguide.dao.TourDao;
import com.topguide.topguide.model.Tour;

import java.util.ArrayList;

public class TouristToursActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Tour> tours;
    private TopGuideApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_tours);

        app = (TopGuideApp) getApplication();

        init();
    }

    public void init() {

        tours = app.getTourDao().getTours();

        listView = (ListView) findViewById(R.id.touristtourslist);
        TourAdapter adapter = new TourAdapter(this, tours);
        listView.setAdapter(adapter);
    }
}
