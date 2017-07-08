package com.topguide.topguide.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.model.Comment;
import com.topguide.topguide.model.Rate;
import com.topguide.topguide.model.Tour;

public class RateTourActivity extends AppCompatActivity {

    private TopGuideApp app;
    private Tour currentTour;
    private SeekBar rateTour;
    private SeekBar rateGuide;
    private EditText commentTour;
    private Button submit;
    private int tourRate;
    private int guideRate;
    private static final int SHOW_TOUR_CODE = 897;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_tour);

        init();
    }

    public void init(){

        app = (TopGuideApp) getApplication();
        currentTour = (Tour) this.getIntent().getExtras().getSerializable("finishedtour");

        setUpElements();
        setUpListeners();
    }

    private void setUpElements(){

        rateTour = (SeekBar) findViewById(R.id.seekbartourrate);
        rateGuide = (SeekBar) findViewById(R.id.seekbarguiderate);
        commentTour = (EditText) findViewById(R.id.commenttouredittext);
        submit = (Button) findViewById(R.id.rateandcommentbutton);
    }

    private void setUpListeners(){

        rateTour.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                tourRate = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    rateGuide.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            guideRate = progress;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });

    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            currentTour.calculateRate(new Rate(tourRate));
            currentTour.getGuide().calculateRate(new Rate(guideRate));

            if(commentTour.getText().toString().trim().length() != 0)

                currentTour.getComments().add(new Comment(commentTour.toString()));

            Intent next = new Intent(RateTourActivity.this, DetailedTourActivity.class);
            next.putExtra("tour", currentTour);
            startActivityForResult(next, SHOW_TOUR_CODE);
        }
    });

    }
}
