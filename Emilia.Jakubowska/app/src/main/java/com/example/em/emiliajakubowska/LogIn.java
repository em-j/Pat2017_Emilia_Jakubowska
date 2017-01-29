package com.example.em.emiliajakubowska;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Em on 2017-01-10.
 */

public class LogIn extends AppCompatActivity {

    // public static final String LOGIN = "LoginPrefs";

    SessionManager session;

    public final static String BASE_SERVER_URL = "http://192.168.1.21:8080";
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        session = new SessionManager(getApplicationContext());
        new DownloadFile().execute(BASE_SERVER_URL + "/page_0.json");
    }

    public void initView() {
        final Button btnLogOut = (Button) findViewById(R.id.btnLogOut);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnLogOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                session.logoutUser();
            }
        });
    }
    public class DownloadFile extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setDoOutput(true);
                urlConnection.connect();


            } catch (final MalformedURLException e) {
                Log.e("MalformedURLException ", "");
                e.printStackTrace();
            } catch (final IOException e) {
                Log.e("IOException", "");
                e.printStackTrace();
            } catch (final Exception e) {
                Log.e("Exception", "");
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String file_url) {
           // progressBar.setVisibility(View.INVISIBLE);

        }

    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }


}
