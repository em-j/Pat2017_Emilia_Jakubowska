package com.example.em.emiliajakubowska.Splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.em.emiliajakubowska.LogIn;
import com.example.em.emiliajakubowska.MainActivity;
import com.example.em.emiliajakubowska.R;
import com.example.em.emiliajakubowska.SessionManager;

/**
 * Created by Em on 2016-12-22.
 */

public class SplashScreen extends Activity {

    private Handler handler;
    Runnable runnable;
    SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        session = new SessionManager(getApplicationContext());

        initViews();
        logedCheck();
    }

    private void initViews() {
        Button stopButton = (Button) findViewById(R.id.button);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(runnable);
            }
        });
    }

    private void logedCheck() {

        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                if (!session.buttonPressed) {
                    if (session.isLoggedIn()) {
                        onStartLogIn();
                    } else {
                        onStartMainActivity();
                    }
                }
            }
        }, 5000);
    }

    private void onStartLogIn() {
        handler.removeCallbacks(runnable);
        Intent i = new Intent(getApplicationContext(), LogIn.class);
        startActivity(i);
        finish();
    }

    private void onStartMainActivity() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
}

