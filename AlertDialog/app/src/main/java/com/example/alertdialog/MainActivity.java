package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSingel, btnDouble, btnTriple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSingel = findViewById(R.id.idBTAlertDialogSingle);
        btnDouble = findViewById(R.id.idBTAlertDialogDouble);
        btnTriple = findViewById(R.id.idBTAlertDialogTriple);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);

        btnSingel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialog.setIcon(R.drawable.info);
                alertDialog.setTitle("Terms & Conditions");
                alertDialog.setMessage("Have you read all the T & C?");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Yes, You can proceed now",Toast.LENGTH_LONG).show();
                    }
                });
                alertDialog.show();
            }
        });

        btnDouble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                delDialog.setIcon(R.drawable.delete);
                delDialog.setTitle("Delete?");
                delDialog.setMessage("Are you sure you want to delete?");
                delDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "You clicked on Yes", Toast.LENGTH_SHORT).show();
                        //for yes
                    }
                });
                delDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "You clicked on No",Toast.LENGTH_SHORT).show();
                    }
                });

                delDialog.show();
            }
        });

    }

    public void onBackPressed(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

        dialog.setIcon(R.drawable.exit);
        dialog.setTitle("Exit ?");
        dialog.setMessage("Do you want to really exit?");
        dialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });
        dialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        dialog.show();
    }
}