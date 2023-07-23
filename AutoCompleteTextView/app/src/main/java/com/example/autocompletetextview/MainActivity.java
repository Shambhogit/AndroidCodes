package com.example.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView actvSubject;
    String []subjects = {"Software Engineering","Computer networking","Database management","GAD","Data Structure","Object oriented programming","Data communication","Principles of database","Digital technics and microprocessor","WPD","Programmin with python","Advanced computer network","Operating system","mobile application development","Network information security","Software testing"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        actvSubject = findViewById(R.id.actvSubject);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.select_dialog_item,subjects);
        actvSubject.setAdapter(adapter);
        actvSubject.setThreshold(1);

    }
}