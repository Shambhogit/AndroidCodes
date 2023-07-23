package com.example.monthlyexpence;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteExpense extends AppCompatActivity {

    GridView gvDeleteItem;
    ArrayList<UserDataModel> userDataModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_expense);

        gvDeleteItem = findViewById(R.id.gvDeleteItem);

        String userID = getIntent().getExtras().getString("userID");

        UserDatabase db = new UserDatabase(DeleteExpense.this);
        userDataModels = db.getData(userID);

        if(userDataModels.size()<=0){
            AlertDialog.Builder confrom = new AlertDialog.Builder(DeleteExpense.this);
            confrom.setIcon(R.drawable.error);
            confrom.setTitle("No Data !!");
            confrom.setMessage("Oops!!, No Record present in data base.");
            confrom.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            confrom.create();
            confrom.show();
        }

        GridAdapter adapter = new GridAdapter(DeleteExpense.this,userDataModels);
        gvDeleteItem.setAdapter(adapter);

    }
}