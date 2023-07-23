package com.example.monthlyexpence;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.contentcapture.DataShareWriteAdapter;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    CardView cvAdd, cvDelete, cvShow, cvSearch;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        cvAdd = findViewById(R.id.cvAdd);
        cvDelete = findViewById(R.id.cvDelete);
        cvSearch = findViewById(R.id.cvSearch);
        cvShow = findViewById(R.id.cvShow);

        Intent intent = getIntent();
        userID = intent.getStringExtra("userID");

        cvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });
        cvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteExpense();
            }
        });
        cvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showExpense();
            }
        });
        cvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchExpense();
            }
        });
    }

    public void addData(){
        Intent add = new Intent(HomePage.this,AddExpense.class);
        add.putExtra("userID",userID);
        startActivity(add);

    }

    public void showExpense(){
        Intent show = new Intent(HomePage.this, ShowExpense.class);
        show.putExtra("userID",userID);
        startActivity(show);
    }

    public void deleteExpense(){
        Intent delete = new Intent(HomePage.this,DeleteExpense.class);
        delete.putExtra("userID",userID);
        startActivity(delete);
    }

    public void searchExpense(){
        Intent search = new Intent(HomePage.this,SearchExpenses.class);
        search.putExtra("userID",userID);
        startActivity(search);
    }

}