package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateName extends AppCompatActivity {

    TextView name,roll,college,className,tread,marks;
    EditText uniqNo,upName;
    ImageView imgBtn;

    Button udtBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        name = findViewById(R.id.tv_name);
        roll = findViewById(R.id.tv_roll);
        college = findViewById(R.id.tv_college);
        className = findViewById(R.id.tv_class);
        tread = findViewById(R.id.tv_tread);
        marks = findViewById(R.id.tv_marks);

        uniqNo = findViewById(R.id.edt_name);
        upName = findViewById(R.id.edt_upname);

        imgBtn = findViewById(R.id.img_btn);
        udtBtn = findViewById(R.id.update_btn);

        StudentDatabase db = new StudentDatabase(this);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> data = db.searchStudent(Integer.parseInt(uniqNo.getText().toString()));

//                String textName = name.getText().toString() + data.get(2);
                name.setText(data.get(2));
//                String textCollege = college.getText().toString() + data.get(5);
                college.setText(data.get(5));
//                String textRoll = roll.getText().toString() + data.get(1);
                roll.setText(data.get(1));
//                String textClass = className.getText().toString() + data.get(3);
                className.setText(data.get(3));
//                String textTread = tread.getText().toString() + data.get(4);
                tread.setText(data.get(4));
//                String textMarks = marks.getText().toString() + data.get(6);
                marks.setText(data.get(6));
            }
        });

        udtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                roll.setText("");
                className.setText("");
                tread.setText("");
                college.setText("");
                marks.setText("");
                try {
                    db.updateName(upName.getText().toString(), Integer.parseInt(uniqNo.getText().toString()));
                    Toast.makeText(UpdateName.this,"Data Updated Successfully",Toast.LENGTH_SHORT).show();
                    upName.setText("");
                    uniqNo.setText("");

                }
                catch (Exception e){
                    Toast.makeText(UpdateName.this,"Your Entering Wrong Input",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}