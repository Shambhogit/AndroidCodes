package com.example.practical_7_b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowInfo extends AppCompatActivity {
    TextView name, number, marks, branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        marks = findViewById(R.id.marks);
        branch = findViewById(R.id.branch);

        Intent i = getIntent();

        String txtName = "Name : "+i.getStringExtra("name");
        String txtNumber = "Number : "+i.getStringExtra("number");
        String txtMarks = "Marks : "+i.getStringExtra("marks");
        String txtBranch= "Branch : "+i.getStringExtra("branch");

        name.setText(txtName);
        number.setText(txtNumber);
        marks.setText(txtMarks);
        branch.setText(txtBranch);

    }
}