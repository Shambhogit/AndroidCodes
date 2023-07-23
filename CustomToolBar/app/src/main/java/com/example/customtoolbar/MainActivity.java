package com.example.customtoolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);

        //step one
        setSupportActionBar(toolbar);

//        step 2
        if (getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My ToolBar");
        }
        toolbar.setSubtitle("Sub Title");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if(itemId==R.id.opt_new){
            Toast.makeText(this,"Clicked new file", Toast.LENGTH_LONG).show();
        }else if(itemId == R.id.opt_opne){
            Toast.makeText(this,"Clicked Open file", Toast.LENGTH_LONG).show();
        }else if(itemId == R.id.opt_save){
            Toast.makeText(this,"Clicked Save file", Toast.LENGTH_LONG).show();
        }else if(itemId == android.R.id.home){
            Toast.makeText(this,"Clicked on Back Button",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}