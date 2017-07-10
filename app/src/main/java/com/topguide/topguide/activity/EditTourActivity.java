package com.topguide.topguide.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.topguide.topguide.R;
import com.topguide.topguide.TopGuideApp;
import com.topguide.topguide.model.Tour;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EditTourActivity extends AppCompatActivity {

    private static final String SUSPEND_TOUR = "Suspend tour";
    private static final String ACTIVATE_TOUR = "Activate tour";
    private static final int BACK_CODE = 100;
    private TopGuideApp app;
    private TextView tourName;
    private TextView stateMessage;
    private Button placeName;
    private Button dateAndTime;
    private Button rating;
    private Button tourPrice;
    private Button tourStatus;
    private Button tourDescription;
    private Button changeState;
    private Tour currentTour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tour);

        app = (TopGuideApp) getApplication();

        init();
    }

    private void init() {
        currentTour = (Tour) this.getIntent().getExtras().getSerializable("tour");

        makeBinds();
        setTourName();

        checkStartDate();

        setButtonLabels();
        setChangeStateLabel();
        setListeners();
    }

    private void checkStartDate() {
        currentTour.getState().dateCheckRequested();
    }

    private void setButtonLabels() {
        placeName.setText(currentTour.getPlaceName().getName());
        dateAndTime.setText(currentTour.getStartDate().toString());
        rating.setText(Double.toString(currentTour.getRate()));
        tourPrice.setText(Double.toString(currentTour.getPrice().getPrice()) + " euros");
        tourStatus.setText(currentTour.getState().askedForStatus());
    }

    private void setChangeStateLabel() {
        if (currentTour.getState().askedForStatus().equals(currentTour.getACTIVE())) {
            changeState.setText(SUSPEND_TOUR);
        } else if (currentTour.getState().askedForStatus().equals(currentTour.getSUSPENDED())) {
            changeState.setText(ACTIVATE_TOUR);
        } else {
            changeState.setVisibility(View.INVISIBLE);
            stateMessage.setVisibility(View.VISIBLE);
        }
    }

    private void setListeners() {

        final LayoutInflater inflater = this.getLayoutInflater();

        final Context context = this;

        placeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View dialogView = inflater.inflate(R.layout.dialog_change_data, null);
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                dialogBuilder.setTitle("Change place");
                dialogBuilder.setView(dialogView);

                final TextView text1 = (TextView) dialogView.findViewById(R.id.text1_id);

                text1.setText("\nEnter new place: ");

                final EditText newPlace = (EditText) dialogView.findViewById(R.id.dialog_new_info);

                newPlace.setHint(currentTour.getPlaceName().getName());

                dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String input = newPlace.getText().toString();
                        if (!input.isEmpty()) {
                            currentTour.getPlaceName().setName(input);
                            placeName.setText(input);
                        }
                    }
                });

                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog dialog = dialogBuilder.create();

                dialog.show();

                setButtonLabels();

            }
        });

        dateAndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newDate(inflater, context, currentTour);

                setButtonLabels();
            }
        });

        tourPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View dialogView = inflater.inflate(R.layout.dialog_change_data, null);
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                dialogBuilder.setTitle("Change price");
                dialogBuilder.setView(dialogView);

                final TextView text1 = (TextView) dialogView.findViewById(R.id.text1_id);

                text1.setText("\nEnter new price: ");

                final EditText newPrice = (EditText) dialogView.findViewById(R.id.dialog_new_info);

                newPrice.setHint(Double.toString(currentTour.getPrice().getPrice()));

                dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String input = newPrice.getText().toString();
                        double newPriceDouble = 0;
                        if (!input.isEmpty()) {
                            try {
                                newPriceDouble = Double.parseDouble(input);
                            } catch (Exception e) {
                                newPriceDouble = 0;
                            }

                            if (newPriceDouble > 0) {
                                currentTour.getPrice().setPrice(newPriceDouble);
                                tourPrice.setText(Double.toString(newPriceDouble));
                            }
                        }
                    }
                });

                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog dialog = dialogBuilder.create();

                dialog.show();

                setButtonLabels();

            }
        });

        tourDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newDescription(inflater, context, currentTour);

                setButtonLabels();
            }
        });
        changeState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTour.getState().stateChangeRequested();
                setChangeStateLabel();
            }
        });
    }

    private void newDescription(LayoutInflater inflater, Context context, Tour currentTour) {

        final View dialogView = inflater.inflate(R.layout.dialog_change_data, null);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Change description");
        dialogBuilder.setView(dialogView);

        final TextView text1 = (TextView) dialogView.findViewById(R.id.text1_id);

        text1.setText("\nEnter new description: ");

        final EditText newDescription = (EditText) dialogView.findViewById(R.id.dialog_new_info);

        newDescription.setHint(currentTour.getDescription());

        final Tour t = currentTour;

        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String input = newDescription.getText().toString();
                if (!input.isEmpty()) {
                    t.setDescription(input);
                    tourDescription.setText(input);
                }
            }
        });

        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog dialog = dialogBuilder.create();

        dialog.show();

    }

    private void newDate(LayoutInflater inflater, final Context context, final Tour currentTour) {
        final View dialogView = inflater.inflate(R.layout.dialog_change_data, null);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Change date");
        dialogBuilder.setView(dialogView);

        final TextView text1 = (TextView) dialogView.findViewById(R.id.text1_id);

        text1.setText("\nEnter new start date: ");

        final EditText newDate = (EditText) dialogView.findViewById(R.id.dialog_new_info);

        final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm");

        newDate.setHint(formatter.format(currentTour.getStartDate()));

        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String input = newDate.getText().toString();
                CharSequence textMessage = "Error: Date and time error detected, wrong input! \nPlease insert correct date and time of tour!";
                CharSequence errorMessage = "Error: Date and time error detected, wrong input format! \nPlease insert date and time in correct format!";
                if (!input.isEmpty()) {
                    try {

                        Date inputDate = formatter.parse(input);
                        Date now = new Date();
                        if (inputDate.before(now))

                            Toast.makeText(context, textMessage, Toast.LENGTH_SHORT).show();

                        else {
                            currentTour.setStartDate(inputDate);

                        }
                    } catch (Exception e) {

                        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog dialog = dialogBuilder.create();

        dialog.show();

    }

    private void setTourName() {
        tourName.setText(currentTour.getName());
    }

    private void makeBinds() {
        tourName = (TextView) findViewById(R.id.edit_tour_name);
        stateMessage = (TextView) findViewById(R.id.edit_tour_state_message);
        placeName = (Button) findViewById(R.id.edit_place);
        dateAndTime = (Button) findViewById(R.id.edit_date);
        rating = (Button) findViewById(R.id.edit_rating);
        tourPrice = (Button) findViewById(R.id.edit_price);
        tourStatus = (Button) findViewById(R.id.edit_status);
        tourDescription = (Button) findViewById(R.id.edit_description);
        changeState = (Button) findViewById(R.id.edit_change_state);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("tour", currentTour);
        setResult(BACK_CODE, intent);
        super.onBackPressed();
    }
}
