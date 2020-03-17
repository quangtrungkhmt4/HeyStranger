package com.benjamin.heystranger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class SplashActivity extends AppCompatActivity {

    private static final int ONE_SECOND = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findId();
        initViews();
    }

    private void initViews() {
        CountDownTimer timer = new CountDownTimer(2 * ONE_SECOND,ONE_SECOND) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashActivity.this, ChatActivity.class));
            }
        };
        timer.start();
    }

    private void findId() {
    }
}
