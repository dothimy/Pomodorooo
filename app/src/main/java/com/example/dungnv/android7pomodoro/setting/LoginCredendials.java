package com.example.dungnv.android7pomodoro.setting;

/**
 * Created by Dell on 1/17/2017.
 */

public class LoginCredendials{
    private String Usernam;
    private String Passwrod;
   // private String accessToken;

    public LoginCredendials(String usernam, String passwrod) {
        Usernam = usernam;
        Passwrod = passwrod;
    //    this.accessToken = accessToken;
    }

//    public String getAccessToken() {
//        return accessToken;
//    }

    public void setUsernam(String usernam) {
        Usernam = usernam;
    }

    public void setPasswrod(String passwrod) {
        Passwrod = passwrod;
    }

//    public void setAccessToken(String accessToken) {
//        this.accessToken = accessToken;
//    }

    public String getUsernam() {
        return Usernam;
    }

    public String getPasswrod() {
        return Passwrod;
    }

    @Override
    public String toString() {
        return "LoginCredendial{" +
                "Usernam='" + Usernam + '\'' +
                ", Passwrod='" + Passwrod + '\'' +
                '}';
    }
}