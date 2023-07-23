package com.example.recyclerviewstudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<StudentStructure> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.id_rv_students);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        students.add(new StudentStructure(R.drawable.man,"Shambho Jaybhaye","Computer Engineering","Rajarambappu Institute of Technology"));
        students.add(new StudentStructure(R.drawable.man,"Ganesh Waje","Computer Engineering","Rajarambappu Institute of Technology"));
        students.add(new StudentStructure(R.drawable.man,"Vijay Jadhav","Computer Engineering","Rajarambappu Institute of Technology"));
        students.add(new StudentStructure(R.drawable.man,"Vishal Gede","Civil Engineering","Rajarambappu Institute of Technology"));
        students.add(new StudentStructure(R.drawable.man,"Tushar Rokde","Mechanical Engineering","Rajarambappu Institute of Technology"));
        students.add(new StudentStructure(R.drawable.man,"Rushi Waje","Computer Engineering","Rajarambappu Institute of Technology"));
        students.add(new StudentStructure(R.drawable.man,"Nitin kide","IT Engineering","CFT Institute of Technology"));
        students.add(new StudentStructure(R.drawable.woman,"Lalita Chavhan","Computer Engineering","Rajarambappu Institute of Technology"));
        students.add(new StudentStructure(R.drawable.woman,"Kalpana Gitte","Computer Engineering","Rajarambappu Institute of Technology"));
        students.add(new StudentStructure(R.drawable.woman,"Vishakha Jaybhaye","Computer Engineering","Rajarambappu Institute of Technology"));
        students.add(new StudentStructure(R.drawable.woman,"Vijaya Kharat","Computer Engineering","Rajarambappu Institute of Technology"));
        students.add(new StudentStructure(R.drawable.woman,"Rekha Kate","Computer Engineering","Rajarambappu Institute of Technology"));
        students.add(new StudentStructure(R.drawable.woman,"Komal Vijaye","Computer Engineering","Rajarambappu Institute of Technology"));
        students.add(new StudentStructure(R.drawable.woman,"Priyanaka Khandekar","Computer Engineering","Rajarambappu Institute of Technology"));

        StudentAdapter adapter = new StudentAdapter(MainActivity.this,students);
        recyclerView.setAdapter(adapter);

    }
}