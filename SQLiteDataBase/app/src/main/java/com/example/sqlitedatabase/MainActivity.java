package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBHelper dbHelper = new MyDBHelper(this);
//        dbHelper.addContact("Shambho", "9970353372");
//        dbHelper.addContact("Ganesh", "9970353372");
//        dbHelper.addContact("Vijay", "9970353372");
//        dbHelper.addContact("Rajesh", "9970353372");
//        dbHelper.addContact("Ganesh", "9970353372");

        //fetch data

//        ArrayList<ContactModal> contact = dbHelper.fetchContacts();

//        for(int i = 0;i<contact.size();i++){
//            Log.d("Contact Infor","name : "+contact.get(i).name+", phone : "+ contact.get(i).phone_no);
//        }
//
        //update data
//        dbHelper.updateContact(new ContactModal(4,"shambho","9900998833"));

        //delete data
        dbHelper.deleteContact(4);

    }
}