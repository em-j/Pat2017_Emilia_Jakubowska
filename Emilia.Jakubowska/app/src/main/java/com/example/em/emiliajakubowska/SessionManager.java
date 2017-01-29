package com.example.em.emiliajakubowska;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by Em on 2017-01-12.
 */

public class SessionManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context ctx;

    int PRIVATE_MODE = 0;

    public static final String PREFER_NAME = "com.example.em.emiliajakubowska";
    public static final String LOGIN = "LoggedIn";
    public static final String KEY_EMAIL = "EMAIL";
    public static final String KEY_PASS = "PASSWORD";
    public boolean buttonPressed = false;

    public SessionManager(Context context) {
        this.ctx = context;
        sharedPreferences = ctx.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void LoginSession(Object uEmail, Object uPass) {

        editor.putBoolean(LOGIN, true);
        editor.putString(KEY_EMAIL, (String) uEmail);
        editor.putString(KEY_PASS, (String) uPass);
        editor.commit();
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();

        Intent i = new Intent(ctx, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        ctx.startActivity(i);
    }


    public void createLogged(boolean login) {
        editor.putBoolean(LOGIN, login);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(LOGIN, false);
    }

}
