package com.topguide.topguide.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.topguide.topguide.R;
import com.topguide.topguide.model.Tour;

public class DetailedTourActivity extends AppCompatActivity {

    Tour currentTour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_tour);

        init();
    }

    public void init(){

        currentTour = (Tour) this.getIntent().getExtras().getSerializable("tour");

    }
}
