package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void sendNow(View view){
        Toast.makeText(this,"This is sending now",Toast.LENGTH_SHORT).show();
    }

    public void deleteNow(View view){
        Toast.makeText(this,"This is Deleting now",Toast.LENGTH_SHORT).show();
    }

    public void reciveNow(View view){
        Toast.makeText(this,"This is Reciving now",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}