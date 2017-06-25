package com.topguide.topguide.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.topguide.topguide.R;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TouristActivity extends AppCompatActivity {

    EditText tourText;
    Button profileButton;
    Button tourButton;
    ArrayList<String> mobileArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist);

        mobileArray.add("Tour1");
        mobileArray.add("Tour2");
        mobileArray.add("Tour3");
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
                String str = tourText.getText().toString();
                Toast msg = Toast.makeText(getBaseContext(),str,Toast.LENGTH_LONG);
                msg.show();
                //show searched tours
            }
        });

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_tourist, mobileArray);

        ListView listView = (ListView) findViewById(R.id.tourslist);
        listView.setAdapter(adapter);
    }
}
