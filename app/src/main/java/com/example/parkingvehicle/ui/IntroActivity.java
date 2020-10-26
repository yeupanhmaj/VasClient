package com.example.parkingvehicle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.parkingvehicle.R;

public class IntroActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(IntroActivity.this, LoginActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                startActivity(homeIntent);
                Animatoo.animateShrink(IntroActivity.this);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
