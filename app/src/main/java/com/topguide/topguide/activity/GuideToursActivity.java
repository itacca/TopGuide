package com.topguide.topguide.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.topguide.topguide.R;
import com.topguide.topguide.adapter.TourAdapter;
import com.topguide.topguide.dao.TourDao;
import com.topguide.topguide.model.Tour;

import java.util.ArrayList;

public class GuideToursActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Tour> tours;
    TourDao tourDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_tours);

        init();
    }

    public void init() {
        tourDao = new TourDao();
        tours = new ArrayList<Tour>();
        tours = tourDao.getTours();

        listView = (ListView) findViewById(R.id.guidetourslist);
        TourAdapter adapter = new TourAdapter(this, tours);
        listView.setAdapter(adapter);
    }
}