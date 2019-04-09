package com.example.introapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

class Session {
    private final SharedPreferences pref;
    private final SharedPreferences.Editor editor;
    private final Context _context;

    // Shared preferences file name
    private static final String PREF_NAME = "snow-intro-slider";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    @SuppressLint("CommitPrefEdits")
    Session(Context context) {
        this._context = context;
        // shared pref mode
        int PRIVATE_MODE = 0;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    void setFirstTimeLaunch() {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, false);
        editor.commit();
    }

    boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}