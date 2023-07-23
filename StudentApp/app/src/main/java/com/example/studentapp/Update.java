package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Update extends AppCompatActivity {

    GridView updateGV;
    ArrayList<UpdateModal> updateModals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        updateGV = findViewById(R.id.id_gv_update);
        updateModals.add(new UpdateModal(R.drawable.name, "Name"));
        updateModals.add(new UpdateModal(R.drawable.roll, "Roll Number"));
        updateModals.add(new UpdateModal(R.drawable.college, "College"));
        updateModals.add(new UpdateModal(R.drawable.marks, "Marks"));
        updateModals.add(new UpdateModal(R.drawable.tread, "Tread"));
        updateModals.add(new UpdateModal(R.drawable.clas, "Class"));

        UpdateCardAdapter adapter = new UpdateCardAdapter(getApplicationContext(), updateModals);
        updateGV.setAdapter(adapter);

    }

}