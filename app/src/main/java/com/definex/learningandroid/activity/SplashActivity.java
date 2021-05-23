package com.definex.learningandroid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.definex.learningandroid.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            //SplashActivity.this.startActivity(new Intent(this, OnboardingActivity.class)
            //        .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
            SplashActivity.this.startActivity(new Intent(this, IslemlerActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));

            SplashActivity.this.finish();
        }, 3000);
    }
}