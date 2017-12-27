package com.example.danie.mycalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class Calendar extends AppCompatActivity {
    ArrayList<String> events;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Intent intent = getIntent();
        if(intent.hasExtra("events")){
            events = intent.getStringArrayListExtra("events");
        }else{
            events = new ArrayList<>();
        }
        Collections.sort(events);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, events);
        ListView view = (ListView) findViewById(R.id.events);
        Button createButton = (Button) findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                buttonPress();
            }
        });
        view.setAdapter(adapter);
    }
    public void buttonPress(){
        Intent intent = new Intent(this, CreateEvent.class);
        intent.putStringArrayListExtra("events", events);
        startActivity(intent);
    }
}
