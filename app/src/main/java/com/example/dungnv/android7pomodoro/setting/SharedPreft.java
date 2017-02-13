package com.example.dungnv.android7pomodoro.setting;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.dungnv.android7pomodoro.SettingSharePref.Setting;
import com.google.gson.Gson;

/**
 * Created by Dell on 1/17/2017.
 */

public class SharedPreft {
    private static final String SHARE_PREFS_NAME = "SP";
    private static final String LOGIN_KEY ="login";
    private static final String SETTING_KEY = "setting";
    private SharedPreferences sharedPreferences;
    private static SharedPreft instance;

    public static SharedPreft getInstance() {
        return instance;
    }
    public static void init(Context context){
        instance=new SharedPreft(context);
    }

    public SharedPreft(Context context){
        this.sharedPreferences=context.getSharedPreferences(
                SHARE_PREFS_NAME,
                context.MODE_PRIVATE
        );
    }
    public void put(LoginCredendials loginCredendials){
        String loginJGON=(new Gson()).toJson(loginCredendials);
        this.sharedPreferences.edit().putString(LOGIN_KEY,loginJGON).commit();
    }
    public void put(Setting setting){
        String settingJGON=(new Gson()).toJson(setting);
        this.sharedPreferences.edit().putString(SETTING_KEY,settingJGON).commit();
    }

    public Setting getSetting(){
        String settingJSON=this.sharedPreferences.getString(SETTING_KEY,null);
        if(settingJSON==null)
            return null;
        Setting setting= (new Gson()).fromJson(settingJSON,Setting.class);
        return setting;
    }
    public LoginCredendials getLoginCredendials(){
        String loginJSON= this.sharedPreferences.getString(LOGIN_KEY,null);
        if(loginJSON==null)return null;
        LoginCredendials loginCredendials=(new Gson()).fromJson(loginJSON,LoginCredendials.class);
        return loginCredendials;
    }

//    public String getAccessToken(){
//        LoginCredendials loginCred= getLoginCredendials();
//        if(loginCred!=null){
//            return loginCred.getAccessToken();
//        }
//        return null;
//    }
}
