package com.example.em.emiliajakubowska;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements IMainActivity {

    EditText email, password;
    Button btnLogIn;
    SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.passsword);
        btnLogIn = (Button) findViewById(R.id.btnLogIn);

        session = new SessionManager(getApplicationContext());

        btnLogIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                //Invalid email and password
                if ((!isEmailValid(email.getText().toString())) && (!isPasswordValid(password.getText().toString()))) {
                    email.setError("Niepoprawny email");
                    password.setError("Niepoprawne hasło");
                    email.requestFocus();
                    password.requestFocus();
                }
                //Invalid email
                else if (!isEmailValid(email.getText().toString())) {
                    email.setError("Niepoprawny email");
                    email.requestFocus();
                }
                //Invalid password
                else if (!isPasswordValid(password.getText().toString())) {
                    password.setError("Niepoprawne hasło");
                    password.requestFocus();
                }
                //Valid correct, go to new intent
                else {
                    email.setError(null);
                    password.setError(null);
                    session.createLogged(true);
                    //pass into activity LogIn

                    Toast.makeText(MainActivity.this, "Zostałaś/eś zalogowany", Toast.LENGTH_LONG).show();
                    startLogIn();

                }
            }
        });
    }


    public void startLogIn() {
        Intent i = new Intent(getApplicationContext(), LogIn.class);
        startActivity(i);
        // close this activity
        finish();
    }

    //Return true when Email is valid and false if email is invalid
    public boolean isEmailValid(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email)
                .matches();
    }

    //Return true when password is valid and false if password is invalid
    private boolean isPasswordValid(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}

