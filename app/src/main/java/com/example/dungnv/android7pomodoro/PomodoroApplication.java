package com.example.dungnv.android7pomodoro;

import android.app.Application;
import android.util.Log;

import com.example.dungnv.android7pomodoro.setting.SharedPreft;

import static android.content.ContentValues.TAG;

/**
 * Created by Dell on 1/17/2017.
 */

public class PomodoroApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreft.init(this);
        Log.d(TAG, "onCreate: %s");

    }
}
