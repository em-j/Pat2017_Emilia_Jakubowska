package com.example.em.emiliajakubowska;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Em on 2017-01-10.
 */

public class LogIn extends AppCompatActivity {

    public static final String LOGIN = "LoginPrefs";
    SessionManager session;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button btnLogOut = (Button) findViewById(R.id.btnLogOut);

        session = new SessionManager(getApplicationContext());
        btnLogOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                session.logoutUser();
            }
        });
    }


    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }


}
