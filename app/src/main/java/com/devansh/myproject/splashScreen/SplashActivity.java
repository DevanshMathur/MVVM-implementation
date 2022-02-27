package com.devansh.myproject.splashScreen;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.devansh.myproject.R;
import com.devansh.myproject.login.LoginActivity;
import com.google.firebase.analytics.FirebaseAnalytics;

public class SplashActivity extends FragmentActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                afterSplash();
                finish();
            }
        },1000);
    }
    void afterSplash()
    {
        startActivity(new Intent(this, LoginActivity.class));
    }
}