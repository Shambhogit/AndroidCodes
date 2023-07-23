package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox oop, dsa, dbms, dma, osy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oop = findViewById(R.id.cbOOP);
        dsa = findViewById(R.id.cbDSA);
        dbms = findViewById(R.id.cbDBMS);
        dma = findViewById(R.id.cbDMA);
        osy = findViewById(R.id.cbOSY);

        oop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(oop.isChecked()) {
                    Toast.makeText(MainActivity.this, "OOP is selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "OOP is Unselected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dsa.isChecked()) {
                    Toast.makeText(MainActivity.this, "DSA is selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "DSA is Unselected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dbms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dbms.isChecked()) {
                    Toast.makeText(MainActivity.this, "DBMS is selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "DBMS is Unselected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        osy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(osy.isChecked()) {
                    Toast.makeText(MainActivity.this, "OSY is selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "OSY is Unselected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dma.isChecked()) {
                    Toast.makeText(MainActivity.this, "DMA is selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "DMA is Unselected", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}