package com.example.danie.mycalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CreateEvent extends AppCompatActivity {
    ArrayList<String> events;
    EditText month;
    EditText day;
    EditText year;
    EditText location;
    EditText name;
    EditText time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        events = getIntent().getStringArrayListExtra("events");
        Button submit = (Button) findViewById(R.id.enter);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                buttonPress();
            }
        });

    }
    public void buttonPress(){
        month = (EditText) findViewById(R.id.month);
        day = (EditText) findViewById(R.id.day);
        year = (EditText) findViewById(R.id.year);
        location = (EditText) findViewById(R.id.location);
        name = (EditText) findViewById(R.id.name);
        time = (EditText) findViewById(R.id.time);
        String monthDat = month.getText().toString();
        int yearDat = Integer.parseInt(year.getText().toString());
        int dayDat = Integer.parseInt(day.getText().toString());
        int timeDat = Integer.parseInt(time.getText().toString());
        String locationDat = location.getText().toString();
        String nameDat = name.getText().toString();
        Event event = new Event(yearDat, monthDat, dayDat, timeDat, locationDat, nameDat);
        events.add(event.toString());
        Intent intent = new Intent(this, Calendar.class);
        intent.putStringArrayListExtra("events", events);
        startActivity(intent);

    }

}
