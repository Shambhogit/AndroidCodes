package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<CardModel> cardModels = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridView = findViewById(R.id.id_gv_menu);

        cardModels.add(new CardModel(R.drawable.insert,"Insert Data"));
        cardModels.add(new CardModel(R.drawable.update,"Update Data"));
        cardModels.add(new CardModel(R.drawable.delete,"Delete Data"));
        cardModels.add(new CardModel(R.drawable.show,"Show Data"));

        ContentAdapter adapter = new ContentAdapter(this,cardModels);
        gridView.setAdapter(adapter);


    }
}