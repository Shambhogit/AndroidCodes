package com.example.monthlyexpence;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class ShowExpense extends AppCompatActivity {

    RecyclerView rvShow;
    String userID;

    ArrayList<UserDataModel> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_expense);
        rvShow = findViewById(R.id.rvShow);
        rvShow.setLayoutManager(new LinearLayoutManager(ShowExpense.this));

        userID = getIntent().getExtras().getString("userID");
        setData(userID);

        if(data.size()<=0){
            AlertDialog.Builder alert = new AlertDialog.Builder(ShowExpense.this);
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
        DataAdapter adapter = new DataAdapter(ShowExpense.this,data);
        rvShow.setAdapter(adapter);
        }
    }

    public void setData(String userID){
        UserDatabase db = new UserDatabase(ShowExpense.this);
        data = db.getData(userID);
    }
}