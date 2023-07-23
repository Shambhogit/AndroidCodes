package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv;
        EditText edtweight,edthightft,edthightin;
        Button btn;

        edtweight = findViewById(R.id.edtweight);
        edthightft = findViewById(R.id.edtHightft);
        edthightin = findViewById(R.id.edthightin);
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv_result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtweight.getText().toString());
                int ft = Integer.parseInt(edthightft.getText().toString());
                int in = Integer.parseInt(edthightin.getText().toString());

                int totalInch = ft*12 + in;
                double totalCm = totalInch*2.53;
                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    tv.setText("You're Overweight");
                }
                else if(bmi<18){
                    tv.setText("You're UnderWeight");
                }
                else {
                    tv.setText("you're Healthy");
                }


            }
        });
    }
}