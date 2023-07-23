package com.example.studentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;

public class UpdateMarks extends AppCompatActivity {
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

        upName.setHint("Enter Updated Marks");

        StudentDatabase db = new StudentDatabase(this);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> data = db.searchStudent(Integer.parseInt(uniqNo.getText().toString()));
                name.setText(data.get(2));
                college.setText(data.get(5));
                roll.setText(data.get(1));
                className.setText(data.get(3));
                tread.setText(data.get(4));
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

                db.updateMarks(Float.parseFloat(upName.getText().toString()), Integer.parseInt(uniqNo.getText().toString()));
                Toast.makeText(UpdateMarks.this,"Data Updated Successfully",Toast.LENGTH_SHORT).show();
                upName.setText("");
                uniqNo.setText("");

            }
        });

    }
}
