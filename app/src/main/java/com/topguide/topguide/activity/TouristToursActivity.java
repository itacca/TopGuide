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
    private ListView listView;
    private ArrayList<Tour> tours;
    private TourDao tourDao;

    private TopGuideApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_tours);

        init();
    }

    public void init() {

    }
}
