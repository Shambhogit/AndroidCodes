package com.example.practical_8_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;

    String []search = {"Apple","animal","Ant","anti","Association","Agree","Ball","Cat","Dog","Elephant","Fish","Horse","Ice-Cream","Joker","Lock","Monday"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.edtSearch);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,search);

        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);


    }
}