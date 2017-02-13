package com.example.dungnv.android7pomodoro.SettingSharePref;

import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Dell on 2/7/2017.
 */

public class Setting {
    private int Working;
    private int Break;
    private int LongBreak;
    private int Spin;

    public Setting(int working, int aBreak, int longBreak, int spin) {
        Working = working;
        Break = aBreak;
        LongBreak = longBreak;
        Spin = spin;
    }

    public int getSpin() {
        return Spin;
    }

    public void setSpin(int spin) {
        Spin = spin;
    }

    public int getWorking() {
        return Working;
    }

    public void setWorking(int working) {
        Working = working;
    }

    public int getBreak() {
        return Break;
    }

    public void setBreak(int aBreak) {
        Break = aBreak;
    }

    public int getLongBreak() {
        return LongBreak;
    }

    public void setLongBreak(int longBreak) {
        LongBreak = longBreak;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "Working=" + Working +
                ", Break=" + Break +
                ", LongBreak=" + LongBreak +
                ", Spin=" + Spin +
                '}';
    }
}
