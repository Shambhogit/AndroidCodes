package com.example.permissionsex;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.READ_SMS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE = 100;
    Button btnReq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReq = findViewById(R.id.btnReq);

        btnReq.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                if(isChecked()){
                    Toast.makeText(MainActivity.this,"Permission Granted",Toast.LENGTH_SHORT).show();
                }
                else{
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{ACCESS_COARSE_LOCATION,READ_SMS},REQ_CODE);

                }

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQ_CODE){
            if(grantResults.length>0){
                int loc = grantResults[0];
                int sms = grantResults[1];

                boolean checkLoc = loc == PackageManager.PERMISSION_GRANTED;
                boolean checkSms = sms == PackageManager.PERMISSION_GRANTED;

                if(checkLoc && checkSms){
                    Toast.makeText(this,"aldkfjkj",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this,"abcdefghijklmnop",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public boolean isChecked(){
        int reqSms = ActivityCompat.checkSelfPermission(this,READ_SMS);
        int reqLoc = ActivityCompat.checkSelfPermission(this,ACCESS_COARSE_LOCATION);

        return reqSms == PackageManager.PERMISSION_GRANTED && reqLoc == PackageManager.PERMISSION_GRANTED;

    }
}