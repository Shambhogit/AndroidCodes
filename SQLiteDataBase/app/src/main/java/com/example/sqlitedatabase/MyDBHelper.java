package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ContactsDB";
    private static final int DATABASE_ID = 1;
    private static final String TABLE_CONTACT = "contacts";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NO = "phone_no";


    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_ID);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //CREATE TABLE contacts (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_no TEXT);
        sqLiteDatabase.execSQL("CREATE TABLE " +TABLE_CONTACT + "(" + KEY_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +KEY_NAME + " TEXT,"+KEY_PHONE_NO+" TEXT "+")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_CONTACT);
        onCreate(sqLiteDatabase);

    }

    public void addContact(String name, String phone_no){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_PHONE_NO, phone_no);

        db.insert(TABLE_CONTACT,null,values);
    }

    public ArrayList<ContactModal> fetchContacts(){
        SQLiteDatabase db = this.getReadableDatabase();

       Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_CONTACT,null);

       ArrayList<ContactModal> contact = new ArrayList<>();

       while (cursor.moveToNext()){
          contact.add(new ContactModal(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
       }
       cursor.close();
       return contact;
    }

    public void updateContact(ContactModal contactModal){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contactModal.name);
        values.put(KEY_PHONE_NO, contactModal.phone_no);

        db.update(TABLE_CONTACT,values,KEY_ID+" = "+contactModal.id,null);
    }

    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACT,KEY_ID+" = "+id,null);
    }
}
