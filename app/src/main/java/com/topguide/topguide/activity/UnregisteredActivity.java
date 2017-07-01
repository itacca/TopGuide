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
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.adapter.TourAdapter;
import com.topguide.topguide.dao.TourDao;
import com.topguide.topguide.model.Tour;

import java.util.ArrayList;

public class UnregisteredActivity extends AppCompatActivity {
    EditText tourText;
    Button tourButton;
    ListView listView;
    ArrayList<Tour> tours;
    TourDao tourDao;

    TopGuideApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unregistered);

        init();
    }

    public void init(){
        tourDao = new TourDao();
        tours = new ArrayList<Tour>();
        tours = tourDao.getTours();
        //tours = app.getTourDao().getTours();

        listView = (ListView) findViewById(R.id.tourslist);
        TourAdapter adapter = new TourAdapter(this, tours);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(UnregisteredActivity.this, "Please log in or register to see detailed tours.", Toast.LENGTH_SHORT).show();
            }
        });

        tourText = (EditText) findViewById(R.id.edittext);

        tourButton = (Button) findViewById(R.id.searchToursButton);
        tourButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String word = tourText.getText().toString();
                ArrayList<Tour> searchedTours = tourDao.searchTours(word);
                // ArrayList<Tour> searchedTours = app.getTourDao().searchTours(word);
                TourAdapter adapter = new TourAdapter(getBaseContext(), searchedTours);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Toast.makeText(UnregisteredActivity.this, "Please register to see detailed tours.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
