package com.example.activitylifecycle;

import static android.Manifest.permission_group.CAMERA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCamera;
    ImageView imgCamear;
    protected static final int REQEST_CODE = 120;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = findViewById(R.id.btnCamera);
        imgCamear = findViewById(R.id.imgCamera);

        btnCamera.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(ActivityCompat.checkSelfPermission(MainActivity.this,CAMERA)==PackageManager.PERMISSION_GRANTED){
                    openCamera();
                }
                else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{CAMERA}, 100);
                }
            }
        });
        Toast.makeText(MainActivity.this,"onCreate() is Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 100){
            if(grantResults.length>0){
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openCamera();
                }
                else{
                    Toast.makeText(MainActivity.this, "Permission not granted", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    protected void onActivityResult(int request, int result, Intent data){
        super.onActivityResult(request,result,data);

        Bitmap image = (Bitmap)data.getExtras().get("data");
        imgCamear.setImageBitmap(image);
    }

    protected void onStart(){
        super.onStart();

        Toast.makeText(MainActivity.this,"onStart() is called",Toast.LENGTH_SHORT).show();
    }

    protected void onResume(){
        super.onResume();

        Toast.makeText(MainActivity.this,"onResume() is called",Toast.LENGTH_SHORT).show();
    }

    protected void onRestart(){
        super.onRestart();

        Toast.makeText(MainActivity.this,"onRestart() is called",Toast.LENGTH_SHORT).show();
    }

    protected void onPause(){
        super.onPause();

        Toast.makeText(MainActivity.this,"onPause() is called",Toast.LENGTH_SHORT).show();
    }

    protected void onStop(){
        super.onStop();

        Toast.makeText(MainActivity.this,"onStop() is called",Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy(){
        super.onDestroy();

        Toast.makeText(MainActivity.this, "onDestroy() is called", Toast.LENGTH_SHORT).show();
    }

    private void openCamera(){
        Intent iCamera = new Intent();
        iCamera.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(iCamera,REQEST_CODE);
    }
}