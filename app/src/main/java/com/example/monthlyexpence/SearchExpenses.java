package com.example.monthlyexpence;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchExpenses extends AppCompatActivity {

    TextView edtDate;
    DatePicker dpDate;
    RecyclerView rvSearch;
    String date , userID ,edtDateText;

    ArrayList<UserDataModel> userDataModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_expenses);

        edtDate = findViewById(R.id.edtSelectDate);
        dpDate = findViewById(R.id.dpDate);
        rvSearch = findViewById(R.id.rvSearch);
        userID = getIntent().getExtras().getString("userID");

        rvSearch.setLayoutManager(new LinearLayoutManager(SearchExpenses.this));

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dpDate.getVisibility()==View.VISIBLE){
                    dpDate.setVisibility(View.GONE);
                    String day = String.valueOf(dpDate.getDayOfMonth());
                    String month = String.valueOf(dpDate.getMonth() + 1);
                    String year = String.valueOf(dpDate.getYear());
                    date = day+"-"+month+"-"+year;
                    edtDate.setText(date);

                    edtDateText = edtDate.getText().toString();
                    UserDatabase db = new UserDatabase(SearchExpenses.this);
                    userDataModels = db.selectDate(userID,date);

                    if(userDataModels.size()<=0){
                        AlertDialog.Builder alert = new AlertDialog.Builder(SearchExpenses.this);
                        alert.setMessage("No data found for user "+ userID);
                        alert.setTitle("No Data Found !!");
                        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                        alert.setIcon(R.drawable.error);
                        alert.create();
                        alert.show();
                    }
                    else {
                        DataAdapter adapter = new DataAdapter(SearchExpenses.this,userDataModels);
                        rvSearch.setAdapter(adapter);
                    }
                }
                else {
                    dpDate.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}