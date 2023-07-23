package com.example.practical_7_b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtName,edtNumber,edtMarks,edtBranch;
    Button btnSubmit;

    Intent iNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        edtMarks = findViewById(R.id.edtMarks);
        edtBranch = findViewById(R.id.edtBranch);

        btnSubmit = findViewById(R.id.btnSubmit);

        iNext = new Intent(MainActivity.this, ShowInfo.class);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ename =edtName.getText().toString();
                String enumber =edtNumber.getText().toString();
                String emarks =edtMarks.getText().toString();
                String ebranch =edtBranch.getText().toString();

                iNext.putExtra("name",ename);
                iNext.putExtra("number",enumber);
                iNext.putExtra("marks",emarks);
                iNext.putExtra("branch",ebranch);

                startActivity(iNext);
            }
        });

    }
}