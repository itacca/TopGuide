package com.topguide.topguide.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.adapter.TourAdapter;
import com.topguide.topguide.dao.TourDao;
import com.topguide.topguide.model.Guide;
import com.topguide.topguide.model.Tour;

import java.util.ArrayList;

public class GuideToursActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final int EDIT_TOURS_CODE = 99;
    private TopGuideApp app;
    private Tour currentTour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_tours);

        app = (TopGuideApp) getApplication();
        Guide currentGuide = (Guide)getIntent().getSerializableExtra("guide");
        init(currentGuide);
    }

    public void init(Guide currentGuide) {
        TourDao tourDao = app.getTourDao();

        ArrayList<Tour> tours = tourDao.getGuideTours(currentGuide.getUser().getUsername());

        ListView listView = (ListView) findViewById(R.id.guidetourslist);
        TourAdapter adapter = new TourAdapter(this, tours);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        currentTour = app.getTourDao().getTours().get(i);

        Intent intent = new Intent(this, EditTourActivity.class);
        intent.putExtra("tour", currentTour);
        startActivityForResult(intent, EDIT_TOURS_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EDIT_TOURS_CODE) {
            if (resultCode == RESULT_OK) {
                currentTour = (Tour) data.getSerializableExtra("tour");
            }
        }
    }
}