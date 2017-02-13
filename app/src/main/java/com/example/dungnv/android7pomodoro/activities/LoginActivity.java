package com.example.dungnv.android7pomodoro.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dungnv.android7pomodoro.R;
import com.example.dungnv.android7pomodoro.setting.LoginCredendials;
import com.example.dungnv.android7pomodoro.setting.SharedPreft;
import com.google.gson.Gson;

//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private EditText etPassword;
    private EditText etUsername;
    private Button btlogin;
    private Button btregister;
    private String TAG = LoginActivity.class.toString();
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
            skipLoginIfPossible();

        etPassword=( EditText) this.findViewById(R.id.et_password);
        etUsername=(EditText)this.findViewById(R.id.et_username);
        btlogin=(Button) this.findViewById(R.id.bt_login);
        btregister=(Button)this.findViewById(R.id.bt_register);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemtLogin();
            }

        });
        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemtRegister();

            }
        });}

    private void skipLoginIfPossible() {
        if(SharedPreft.getInstance().getLoginCredendials()!=null){
            gotostart();
        }
    }

    private void attemtLogin(){
        String Username= etUsername.getText().toString();
        String Password=etPassword.getText().toString();
        if(Username.equals("admin")&& Password.equals("admin"))
        {
            SharedPreft.getInstance().put(new LoginCredendials(Username,Password));
            Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show();
            Log.d(TAG,"login");
           gotostart();
        }else {
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "login failed ");
        }
    }
    private void attemtRegister(){
        String Username=etUsername.getText().toString();
        String Password=etPassword.getText().toString();
        if(Username.equals("admin")){
            Toast.makeText(this, "Register failed", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this, "Register success", Toast.LENGTH_SHORT).show();
    }
    public void gotostart(){
        Intent intent=new Intent(this,TaskActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
