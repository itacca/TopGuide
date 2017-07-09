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


public class GuideActivity extends AppCompatActivity {

    private EditText tourText;
    private Button profileButton;
    private Button tourButton;
    private Button newTourButton;
    private ListView listView;
    private Tour currentTour;
    private TopGuideApp app;
    private boolean error;

    private static final int DETAILED_TOUR_CODE = 18;
    private static final int EDIT_TOUR_CODE = 118;
    private static final int CREATE_TOUR_CODE = 442;
    private static final int CODE_GUIDE_PROFILE = 566;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        context = this;
        init();
    }

    private void init() {

        app = (TopGuideApp) getApplication();

        listView = (ListView) findViewById(R.id.tourslist);
        TourAdapter adapter = new TourAdapter(this, app.getTourDao().getTours());
        listView.setAdapter(adapter);

        tourText = (EditText) findViewById(R.id.edittext);


        profileButton = (Button) findViewById(R.id.profilebutton_guide);
        profileButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, GuideProfileActivity.class);
                startActivityForResult(intent, CODE_GUIDE_PROFILE);
            }
        });

        newTourButton = (Button) findViewById(R.id.newtourbutton);
        newTourButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                error = false;
                if(app.getPersonDao().getCurrentGuide().getRates().size() >= 10){

                    if(app.getPersonDao().getCurrentGuide().getRate().getRate() < 2)

                        error = true;
                }

                if(!error){

                    Intent next = new Intent(GuideActivity.this, CreateTourActivity.class);
                    startActivityForResult(next, CREATE_TOUR_CODE);
                }

                else

                    newTourButton.setText("OPTION DISABLED!\n DUE TO LOW RATE YOU CAN NOT CREATE TOURS!");

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

            if(app.getUserDao().getCurrentUser().getUsername().equals(currentTour.getGuide().getUser().getUsername())) {
                Intent next = new Intent(context, EditTourActivity.class);
                next.putExtra("tour", currentTour);
                startActivityForResult(next, EDIT_TOUR_CODE);
            }
            else{

                Intent next = new Intent(context, DetailedTourActivity.class);
                next.putExtra("tour", currentTour);
                startActivityForResult(next, DETAILED_TOUR_CODE);
            }
            }
        });
    }
}