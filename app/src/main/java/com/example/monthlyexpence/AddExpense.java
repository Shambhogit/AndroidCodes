package com.example.monthlyexpence;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AddExpense extends AppCompatActivity {

    EditText edtReason, edtDiscription, edtCost;
    RadioGroup rbgType;
    TextView tvDate;
    Button btnAddExpense;

    DatePicker dpDate;

    String date, userID, reason, cost, type, discription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        edtReason = findViewById(R.id.edtReason);
        edtCost = findViewById(R.id.edtCost);
        tvDate = findViewById(R.id.tvDate);
        edtDiscription = findViewById(R.id.edtDiscription);
        rbgType = findViewById(R.id.rbgType);
        btnAddExpense = findViewById(R.id.btnAddExpense);
        dpDate = findViewById(R.id.dpDate);


        rbgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int rid = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(rid);
                type = radioButton.getText().toString();
            }
        });


        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dpDate.getVisibility() == View.VISIBLE){
                    dpDate.setVisibility(View.GONE);
                    String day = String.valueOf(dpDate.getDayOfMonth());
                    String month = String.valueOf(dpDate.getMonth()+1);
                    String year = String.valueOf(dpDate.getYear());
                    date = day+"-"+month+"-"+year;
                    tvDate.setText(date);
                }else {
                    dpDate.setVisibility(View.VISIBLE);
                }
            }
        });

        btnAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpence();
            }
        });
    }
    public void getData(){
        userID = getIntent().getExtras().getString("userID");
        cost = edtCost.getText().toString();
        reason = edtReason.getText().toString();
        discription = edtDiscription.getText().toString();
    }

    public void addExpence(){
        getData();
        if(reason.equals("") || reason.isEmpty()){
            Toast.makeText(AddExpense.this, "Please Enter Reason", Toast.LENGTH_SHORT).show();
        }
        else if(cost.isEmpty() || cost.equals("")){
            Toast.makeText(AddExpense.this, "Please Enter Cost", Toast.LENGTH_SHORT).show();
        }
        else if(type.equals("")|| type.isEmpty()){
            Toast.makeText(AddExpense.this, "Please Select Expense Type", Toast.LENGTH_SHORT).show();
        }
        else if(date.isEmpty() || date.equals("Click to Select Date")){
            Toast.makeText(AddExpense.this, "Click to Select Date", Toast.LENGTH_SHORT).show();
        }
        else if(discription.isEmpty()||discription.equals("")){
            Toast.makeText(AddExpense.this, "Please Enter Discription", Toast.LENGTH_SHORT).show();
        }
        else {
            UserDatabase db = new UserDatabase(AddExpense.this);
            db.addExpense(userID,reason,cost,date,type,discription);
            Toast.makeText(AddExpense.this, "Expense Added...!!", Toast.LENGTH_SHORT).show();
            clearData();
        }
    }
    public void clearData(){
        edtCost.setText(null);
        edtReason.setText(null);
        tvDate.setText("Click to Select Date");
        edtDiscription.setText(null);
    }
}