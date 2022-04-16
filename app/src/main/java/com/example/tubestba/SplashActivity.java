package com.example.tubestba;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;
import android.transition.Transition;
import android.view.Window;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this);
//                overridePendingTransition(R.transition.fade_in, R.transition.fade_out);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}