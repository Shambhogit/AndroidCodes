package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {

    Button insert, clear;
    EditText et_roll , et_name, et_class, et_tread, et_college, et_marks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        insert = findViewById(R.id.id_btn_insert);
        clear = findViewById(R.id.id_btn_clear);
        et_roll = findViewById(R.id.id_tv_rollNumber);
        et_name = findViewById(R.id.id_tv_name);
        et_class = findViewById(R.id.id_tv_class);
        et_tread = findViewById(R.id.id_tv_tread);
        et_college = findViewById(R.id.id_tv_college);
        et_marks = findViewById(R.id.id_tv_marks);


        insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                StudentDatabase db = new StudentDatabase(getApplicationContext());

                int rollNumber = Integer.parseInt(et_roll.getText().toString());
                String name = et_name.getText().toString();
                String stdClass = et_class.getText().toString();
                String tread = et_tread.getText().toString();
                String college = et_college.getText().toString();
                float marks = Float.parseFloat(et_marks.getText().toString());

                db.insertStudent(new StudentModal(rollNumber,name,stdClass,tread,college,marks));
                Toast.makeText(getApplicationContext(),"Data Inserted Successfully",Toast.LENGTH_SHORT).show();
                clear();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
    }

    private void clear(){
        et_name.setText("");
        et_roll.setText("");
        et_college.setText("");
        et_tread.setText("");
        et_marks.setText("");
        et_class.setText("");
    }
}