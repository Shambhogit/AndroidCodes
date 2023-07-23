package com.example.monthlyexpence;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnSingUp;
    EditText edtUserID, edtPassword;

    String userId,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSingUp = findViewById(R.id.btnSignUp);

        edtUserID = findViewById(R.id.edtUserID);
        edtPassword = findViewById(R.id.edtPassword);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isExist() == 1){
                    Intent home = new Intent(MainActivity.this, HomePage.class);
                    home.putExtra("userID",edtUserID.getText().toString());
                    startActivity(home);
                    clearData();
                    MainActivity.this.finish();
                }
                else if (isExist() == 2){
                    AlertDialog.Builder errorPassword = new AlertDialog.Builder(MainActivity.this);
                    errorPassword.setTitle("Wrong password!");
                    errorPassword.setMessage("Check your password it is not matching with userID "+edtUserID.getText().toString());
                    errorPassword.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                        }
                    });
                    errorPassword.setIcon(R.drawable.error);
                    errorPassword.create();
                    errorPassword.show();
                    clearData();
                }
                else if (isExist() == 0){
                    AlertDialog.Builder errorPassword = new AlertDialog.Builder(MainActivity.this);
                    errorPassword.setTitle("User Not Exist!");
                    errorPassword.setMessage("Check your userID, it not Exist "+edtUserID.getText().toString());
                    errorPassword.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "No user Found", Toast.LENGTH_SHORT).show();
                        }
                    });
                    errorPassword.setIcon(R.drawable.error);
                    errorPassword.create();
                    errorPassword.show();
                }
            }
        });

        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(MainActivity.this, SignUp.class);
                startActivity(signUp);
            }
        });
    }

    public int isExist(){

        UserDatabase db = new UserDatabase(MainActivity.this);
        ArrayList<DataModale> data = db.getAllUserInfo();
        getData();
        if(data.size()>0) {
            for (DataModale user : data) {
                if (user.userID.equals(userId) && user.password.equals(password)) {
                    return 1;
                } else if (user.userID.equals(userId)) {
                    return 2;
                }
            }
        }
        else{
            return 0;
        }

        return 0;
    }

    public void getData(){
        userId = edtUserID.getText().toString();
        password = edtPassword.getText().toString();
    }

    public void clearData(){
        edtPassword.setText(null);
        edtUserID.setText(null);
    }
}