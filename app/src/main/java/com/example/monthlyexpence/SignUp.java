package com.example.monthlyexpence;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity {

    Button btnClear, btnSubmit;
    EditText edtNameC, edtPhoneC, edtUserIDC, edtPasswordC;
    String name, phone, userID, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnClear = findViewById(R.id.btnClear);
        btnSubmit = findViewById(R.id.btnSubmit);

        edtNameC = findViewById(R.id.edtNameC);
        edtPhoneC = findViewById(R.id.edtPhoneC);
        edtUserIDC = findViewById(R.id.edtUserIDC);
        edtPasswordC = findViewById(R.id.edtPasswordC);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearData();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isUserExists()) {
                    AlertDialog.Builder error = new AlertDialog.Builder(SignUp.this);
                    error.setTitle("User Already Exists!!!");
                    error.setMessage("User " + userID + " is Already Exists please change user name");
                    error.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    error.setIcon(R.drawable.error);
                    error.create();
                    error.show();
                }else if(checkFields() && validateUserInput()){
                   insertUserData();
                   clearData();

                   LayoutInflater li = getLayoutInflater();
                   View view1 = li.inflate(R.layout.ok_toast,findViewById(R.id.toast));
                   Toast toast = new Toast(SignUp.this);
                   toast.setView(view1);
                   toast.setDuration(Toast.LENGTH_SHORT);
                   toast.setGravity(Gravity.CENTER,0,0);
                   toast.show();
                   SignUp.this.finish();
               } else {
                   AlertDialog.Builder error = new AlertDialog.Builder(SignUp.this);
                   error.setTitle("Fill Proper Input!!!");
                   error.setMessage("Fields are empty, or may be not valid please fill it properly.");
                   error.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {

                       }
                   });
                   error.setIcon(R.drawable.error);
                   error.create();
                   error.show();
               }
            }
        });
    }

    public boolean isUserExists(){

        UserDatabase db = new UserDatabase(SignUp.this);
        ArrayList<String> ids = db.getUserIDs();
        if(ids.size()==0){
            return false;
        }
        else{
            getData();

            for(String id : ids){
                if(id.equals(userID)){
                    return true;
                }
            }
            return false;
        }
    }

    public void insertUserData(){
        UserDatabase db = new UserDatabase(SignUp.this);
        getData();

        DataModale data = new DataModale(name,phone,userID,password);
        db.insertUser(data);
    }


    public boolean checkFields(){
        boolean result = true;
        getData();
        if(name.isEmpty() || name.equals("")){
            showAlertDialog(edtNameC.getHint().toString());
            result = false;
        } else if (phone.isEmpty() || phone.equals("")) {
            showAlertDialog(edtPhoneC.getHint().toString());
            result = false;
        } else if (userID.isEmpty() || userID.equals("")) {
            showAlertDialog(edtUserIDC.getHint().toString());
            result = false;
        } else if (password.isEmpty() || password.equals("")){
            showAlertDialog(edtPasswordC.getHint().toString());
            result = false;
        }
        return result;
    }

    public boolean validateUserInput(){
        boolean result = true;
        getData();
        if(password.length()<8){
            Toast.makeText(this, "Password must be of 8 characters", Toast.LENGTH_SHORT).show();
            result = false;
        } else if (userID.length()<8) {
            Toast.makeText(this, "User ID is too Small", Toast.LENGTH_SHORT).show();
            result = false;
        }else if (phone.length()<10 || phone.length() > 10){
            Toast.makeText(this, "Phone number is not valid", Toast.LENGTH_SHORT).show();
            result = false;
        }
        return result;
    }


    public void clearData(){
        edtNameC.setText(null);
        edtPhoneC.setText(null);
        edtUserIDC.setText(null);
        edtPasswordC.setText(null);
    }

    public void getData(){
        name = edtNameC.getText().toString();
        phone = edtPhoneC.getText().toString();
        userID = edtUserIDC.getText().toString();
        password = edtPasswordC.getText().toString();
    }

    public void showAlertDialog(String data){
        AlertDialog.Builder error = new AlertDialog.Builder(SignUp.this);
        error.setTitle(data + "!!!");
        error.setMessage("Field "+ data + " is empty please fill it properly.");
        error.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(SignUp.this, "Fill "+data, Toast.LENGTH_SHORT).show();
            }
        });
        error.setIcon(R.drawable.error);
        error.create();
        error.show();
    }
}