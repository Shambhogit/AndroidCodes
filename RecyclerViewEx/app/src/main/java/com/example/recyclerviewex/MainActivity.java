package com.example.recyclerviewex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> contact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recViewContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contact.add(new ContactModel(R.drawable.man,"Shambho","9730827236"));
        contact.add(new ContactModel(R.drawable.man,"ganesh","9730827236"));
        contact.add(new ContactModel(R.drawable.man,"vijay","9730827236"));
        contact.add(new ContactModel(R.drawable.woman,"Srushti","9730827236"));
        contact.add(new ContactModel(R.drawable.man,"raj","9730827236"));
        contact.add(new ContactModel(R.drawable.woman,"rani","9730827236"));
        contact.add(new ContactModel(R.drawable.woman,"Rita","9730827236"));
        contact.add(new ContactModel(R.drawable.man,"vishal","9730827236"));
        contact.add(new ContactModel(R.drawable.man,"vaibhav","9730827236"));
        contact.add(new ContactModel(R.drawable.man,"mahadev","9730827236"));
        contact.add(new ContactModel(R.drawable.man,"gajanan","9730827236"));
        contact.add(new ContactModel(R.drawable.man,"Omkar","9730827236"));
        contact.add(new ContactModel(R.drawable.woman,"vijaya","9730827236"));
        contact.add(new ContactModel(R.drawable.woman,"Laxmi","9730827236"));
        contact.add(new ContactModel(R.drawable.woman,"gayatri","9730827236"));
        contact.add(new ContactModel(R.drawable.woman,"Priyanka","9730827236"));
        contact.add(new ContactModel(R.drawable.woman,"Komal","9730827236"));
        contact.add(new ContactModel(R.drawable.man,"rajan","9730827236"));
        contact.add(new ContactModel(R.drawable.man,"gautam","9730827236"));
        contact.add(new ContactModel(R.drawable.woman,"prerana","9730827236"));
        contact.add(new ContactModel(R.drawable.man,"Shambho","9730827236"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,contact);
        recyclerView.setAdapter(adapter);

    }
}
