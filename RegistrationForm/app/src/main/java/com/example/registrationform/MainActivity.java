package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView circle_one, circle_two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation b = AnimationUtils.loadAnimation(this,R.anim.anim2);
        circle_two = findViewById(R.id.circle_two);
        circle_two.startAnimation(b);

        Animation a = AnimationUtils.loadAnimation(this,R.anim.translate);
        circle_one = findViewById(R.id.circle_one);
        circle_one.startAnimation(a);
    }
}