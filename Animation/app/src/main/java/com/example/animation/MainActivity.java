package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtAnim;
Button btnTranslate, btnAlpha, btnScale, btnRotate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAnim = findViewById(R.id.text);
        btnAlpha = findViewById(R.id.alpha);
        btnTranslate = findViewById(R.id.translate);
        btnRotate = findViewById(R.id.rotate);
        btnScale = findViewById(R.id.scale);

        Animation move = AnimationUtils.loadAnimation(this,R.anim.move);
        Animation rotate = AnimationUtils.loadAnimation(this,R.anim.rotate);
        Animation scale = AnimationUtils.loadAnimation(this,R.anim.scale);
        Animation alpha = AnimationUtils.loadAnimation(this,R.anim.alpha);

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAnim.startAnimation(move);
            }
        });

        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAnim.startAnimation(scale);
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAnim.startAnimation(rotate);
            }
        });

        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAnim.startAnimation(alpha);
            }
        });

    }
}