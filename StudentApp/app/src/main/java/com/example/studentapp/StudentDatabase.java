package com.example.studentapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class StudentDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students";
    private static final String TABLE_NAME = "students_data";
    private static final String SERIAL_NUMBER = "serial_number";
    private static final String ROLL_NUMBER = "roll_number";
    private static final String STUDENT_NAME = "students_name";
    private static final String STUDENT_CLASS = "students_class";
    private static final String STUDENT_TREAD = "students_tread";
    private static final String STUDENT_COLLEGE = "students_college";
    private static final String STUDENT_MARKS = "students_marks";
    private static final String UNIQE_ID = "student_id";



    private static final int DATABASE_VERSION = 1;


    public StudentDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+"("+UNIQE_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+ROLL_NUMBER+" INTEGER, "+STUDENT_NAME+" TEXT,"+STUDENT_CLASS+" TEXT, "+STUDENT_TREAD+" TEXT, "+STUDENT_COLLEGE+" TEXT, "+STUDENT_MARKS+" FLOAT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertStudent(StudentModal studentInformation){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ROLL_NUMBER, studentInformation.rollNumber);
        values.put(STUDENT_NAME, studentInformation.studentName);
        values.put(STUDENT_CLASS, studentInformation.studentClass);
        values.put(STUDENT_TREAD, studentInformation.studentTread);
        values.put(STUDENT_COLLEGE, studentInformation.studentcollege);
        values.put(STUDENT_MARKS, studentInformation.marks);
        db.insert(TABLE_NAME,null,values);
//        db.close();
    }

    public ArrayList<String> searchStudent(int uniqNo){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME +" WHERE "+UNIQE_ID+" = "+uniqNo,null);
        ArrayList<String> studData = new ArrayList<>();
        while (data.moveToNext()) {
            studData.add("" + data.getInt(0));
            studData.add("" + data.getInt(1));
            studData.add("" + data.getString(2));
            studData.add("" + data.getString(3));
            studData.add("" + data.getString(4));
            studData.add("" + data.getString(5));
            studData.add("" + data.getFloat(6));
        }
        return studData;
    }
    public void updateName(String name , int uniqid) throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STUDENT_NAME,name);
        db.update(TABLE_NAME,values,UNIQE_ID+"="+uniqid,null);

    }

    public void updateRoll(int roll, int uniqid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ROLL_NUMBER,roll);
        db.update(TABLE_NAME,values,UNIQE_ID+"="+uniqid,null);
    }
    public void updateCollege(String college, int uniqid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STUDENT_COLLEGE,college);
        db.update(TABLE_NAME,values,UNIQE_ID+"="+uniqid,null);
    }
    public void updateMarks(float marks, int uniqid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STUDENT_MARKS,marks);
        db.update(TABLE_NAME,values,UNIQE_ID+"="+uniqid,null);
    }
    public void updateTread(String tread, int uniqid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STUDENT_TREAD,tread);
        db.update(TABLE_NAME,values,UNIQE_ID+"="+uniqid,null);
    }
    public void updateClass(String className, int uniqid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STUDENT_CLASS,className);
        db.update(TABLE_NAME,values,UNIQE_ID+"="+uniqid,null);
    }

    public ArrayList<DataModal> getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<DataModal> dataModals = new ArrayList<>();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        while (data.moveToNext()){
            dataModals.add(new DataModal(data.getInt(0),data.getInt(1),data.getString(2),data.getString(3),data.getString(4),data.getString(5),data.getFloat(6)));
        }
        data.close();
        return dataModals;
    }

    public void deleteData(int uniqNo){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,UNIQE_ID+"="+uniqNo,null);
    }
}
