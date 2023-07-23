package com.example.typeoflistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
TextView noob;
Spinner spinner;
AutoCompleteTextView actv;
ArrayList<String> arrNamas = new ArrayList<>();
ArrayList<String> arrIds = new ArrayList<>();
ArrayList<String> arrLans = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        actv = findViewById(R.id.actv);
        listView = findViewById(R.id.listView);
        noob = findViewById(R.id.noob);

        arrNamas.add("shambho");
        arrNamas.add("Ganesh");
        arrNamas.add("Vishal");
        arrNamas.add("Vinod");
        arrNamas.add("Gaurav");
        arrNamas.add("Mandar");
        arrNamas.add("Vijay");
        arrNamas.add("Gautam");
        arrNamas.add("Priyanka");
        arrNamas.add("Namrata");
        arrNamas.add("Komal");
        arrNamas.add("Aditi");
        arrNamas.add("Neha");
        arrNamas.add("Prathamesh");
        arrNamas.add("Shresyas");
        arrNamas.add("vijaya");
        arrNamas.add("Arti");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrNamas);
        listView.setAdapter(adapter);


        arrIds.add("Aadhar card");
        arrIds.add("Pan card");
        arrIds.add("Voter Id card");
        arrIds.add("Ration card");
        arrIds.add("Xth score card");
        arrIds.add("XIIth score card");
        ArrayAdapter<String> idadpt = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrIds);
        spinner.setAdapter(idadpt);





        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Toast.makeText(MainActivity.this, "Clicked first item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        arrLans.add("marathi");
        arrLans.add("English");
        arrLans.add("Hindi");
        arrLans.add("Gujarati");
        arrLans.add("Mallyalam");
        arrLans.add("Panjabi");
        arrLans.add("Kannad");

        ArrayAdapter<String> adplang = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrLans);
        actv.setAdapter(adplang);
        actv.setThreshold(2);

//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if(i == 0){
//                    noob.setText(idadpt.getItem(0));
//                }
//            }
//        });

    }
}