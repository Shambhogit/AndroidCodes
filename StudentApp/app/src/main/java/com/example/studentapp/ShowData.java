package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ShowData extends AppCompatActivity {

    RecyclerView rvDataCard ;

    ArrayList<DataModal> dataModals = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        StudentDatabase db = new StudentDatabase(this);
        dataModals = db.getAllData();

        rvDataCard = findViewById(R.id.rvDataCard);
        rvDataCard.setLayoutManager(new LinearLayoutManager(this));

        DataAdapter adapter = new DataAdapter(this,dataModals);

        rvDataCard.setAdapter(adapter);
    }
}