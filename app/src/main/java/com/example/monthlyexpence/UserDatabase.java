package com.example.monthlyexpence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class UserDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user_data";
    private static final int DATABASE_ID = 1;


    private static final String TABLE_NAME = "users";
    private static final String USER_NAME = "user_name";
    private static final String USER_PHONE = "phone";
    private static final String USER_ID = "userID";
    private static final String USER_PASSWORD = "password";


    private static final String USER_TABLE_NAME = "user_data";
    private static final String EXPENSE_REASON  = "expense_reason";
    private static final String EXPENSE_COST = "expense_cost";
    private static final String EXPENSE_DATE = "expense_date";
    private static final String EXPENSE_TYPE = "expense_type";
    private static final String EXPENSE_DISCRIPTION = "expense_discription";



    public UserDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_ID);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+"("+USER_NAME+" TEXT,"+USER_PHONE+" TEXT,"+USER_ID+" TEXT,"+USER_PASSWORD+" TEXT"+")");

        sqLiteDatabase.execSQL("CREATE TABLE "+USER_TABLE_NAME+"("+USER_ID+" TEXT,"+EXPENSE_REASON+" TEXT,"+EXPENSE_COST+" TEXT,"+EXPENSE_DATE+" TEXT,"+EXPENSE_TYPE+" TEXT,"+EXPENSE_DISCRIPTION+" TEXT"+")");
    }
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int v1, int v2){
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE "+USER_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertUser(DataModale user){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME,user.name);
        values.put(USER_PHONE,user.phone);
        values.put(USER_ID,user.userID);
        values.put(USER_PASSWORD,user.password);

        db.insert(TABLE_NAME,null,values);
    }

    public ArrayList<String> getUserIDs(){

        ArrayList<String> userIDs = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor =  db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        while (cursor.moveToNext()){
            userIDs.add(cursor.getString(2));
        }
        cursor.close();

        return userIDs;
    }

    public ArrayList<DataModale> getAllUserInfo(){
        ArrayList<DataModale> userData = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        while(cursor.moveToNext()){
            userData.add(new DataModale(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
        }
        cursor.close();
        return userData;
    }

    public void addExpense(String userID,String reason, String cost, String date, String type, String discription){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();

        data.put(USER_ID,userID);
        data.put(EXPENSE_REASON,reason);
        data.put(EXPENSE_COST,cost);
        data.put(EXPENSE_DATE,date);
        data.put(EXPENSE_TYPE,type);
        data.put(EXPENSE_DISCRIPTION,discription);

        db.insert(USER_TABLE_NAME,null,data);
    }

    public ArrayList<UserDataModel> getData(String userID){

        ArrayList<UserDataModel> userData = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+USER_TABLE_NAME+" WHERE "+USER_ID+"='"+userID+"'",null);
        while (data.moveToNext()){
            userData.add(new UserDataModel(data.getString(0),data.getString(1),data.getString(2),data.getString(3),data.getString(4),data.getString(5)));
        }

        data.close();
        return userData;
    }

    public int deleleExpense(UserDataModel userDataModel){
        SQLiteDatabase db = getReadableDatabase();
        int line = db.delete(USER_TABLE_NAME,USER_ID+"=? AND "+EXPENSE_REASON+"=? AND "+EXPENSE_COST+"=? AND "+EXPENSE_DATE+"=?",new String[]{userDataModel.userID,userDataModel.reason,userDataModel.cost,userDataModel.date});

        return line;
    }

    public ArrayList<UserDataModel> selectDate(String userID,String date){
        ArrayList<UserDataModel> userDataModels = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+USER_TABLE_NAME+" WHERE "+EXPENSE_DATE+"='"+date+"' AND "+USER_ID+"='"+userID+"'",null);
        while (data.moveToNext()){
            userDataModels.add(new UserDataModel(data.getString(0),data.getString(1),data.getString(2),data.getString(3),data.getString(4),data.getString(5)));
        }
        data.close();
        return  userDataModels;
    }
}
