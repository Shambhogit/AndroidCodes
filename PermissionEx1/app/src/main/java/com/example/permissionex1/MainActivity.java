package com.example.permissionex1;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.SEND_SMS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnReq;
    protected static final int REQUEST_CODE = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReq = findViewById(R.id.btnReq);

        btnReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkPermission()){
                    Toast.makeText(MainActivity.this, "permission granted", Toast.LENGTH_SHORT).show();
                }
                else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{SEND_SMS, CALL_PHONE, ACCESS_COARSE_LOCATION}, REQUEST_CODE);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == REQUEST_CODE){
            if(grantResults.length>0){
                boolean a = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean b = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                boolean c = grantResults[2] == PackageManager.PERMISSION_GRANTED;
                
                if(a && b && c){
                    Toast.makeText(MainActivity.this, "Permissions are granted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Permissions are dinaed", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public boolean checkPermission(){
        int perSms = ActivityCompat.checkSelfPermission(MainActivity.this,SEND_SMS);
        int perCall = ActivityCompat.checkSelfPermission(MainActivity.this,CALL_PHONE);
        int perLoc = ActivityCompat.checkSelfPermission(MainActivity.this,ACCESS_COARSE_LOCATION);

        return perLoc == PackageManager.PERMISSION_GRANTED && perCall == PackageManager.PERMISSION_GRANTED && perSms == PackageManager.PERMISSION_GRANTED;
    }
}