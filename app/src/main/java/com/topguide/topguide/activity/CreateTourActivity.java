package com.topguide.topguide.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.model.Guide;
import com.topguide.topguide.model.Pricelist;
import com.topguide.topguide.model.Tour;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateTourActivity extends AppCompatActivity {

    private EditText tourNameText;
    private EditText placeNameText;
    private EditText dateText;
    private EditText priceText;
    private EditText descriptionText;
    private TextView statusText;
    private Button createTourButton;
    private TopGuideApp app;
    private int MAIN_CODE = 232;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tour);

        init();
    }

    private void init() {

        app = (TopGuideApp) getApplication();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        tourNameText = (EditText) findViewById(R.id.insertourname);
        placeNameText = (EditText) findViewById(R.id.insertplacename);
        dateText = (EditText) findViewById(R.id.insertdate);
        priceText = (EditText) findViewById(R.id.insertprice);
        descriptionText = (EditText) findViewById(R.id.insertdescription);
        statusText = (TextView) findViewById(R.id.tourerror) ;

        createTourButton = (Button) findViewById(R.id.createtourbutton);
        createTourButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(isEmpty(tourNameText) || isEmpty(placeNameText) || isEmpty(dateText) || isEmpty(priceText) || isEmpty(descriptionText))

                    statusText.setText("Error: Not all fields have been filled! \nPlease fill all the fileds with correct information!");

                else {

                    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
                    try {

                        Date inputDate = formatter.parse(dateText.getText().toString());
                        Date now = new Date();
                        if (inputDate.before(now))

                            statusText.setText("Error: Date and time error detected, wrong input! \nPlease insert correct date and time of tour!");

                        else {
                            Tour newTour = app.getTourDao().createTour(tourNameText.getText().toString(), placeNameText.getText().toString(),
                                    inputDate, new Pricelist(Double.parseDouble(priceText.getText().toString()), inputDate),
                                    descriptionText.getText().toString(), app.getPersonDao().getCurrentGuide());

                            app.getPersonDao().getCurrentGuide().getTours().add(newTour);

                            Toast.makeText(app, "Uspesno kreirana tura!", Toast.LENGTH_SHORT).show();

                            Intent next = new Intent();
                            setResult(MAIN_CODE, next);
                        }
                    } catch (Exception e) {

                        statusText.setText("Error: Date and time error detected, wrong input format! \nPlease insert date and time in correct format!");
                    }
                }
            }
        });
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }
}
