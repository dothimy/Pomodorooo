package com.example.dungnv.android7pomodoro.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dungnv.android7pomodoro.R;
import com.example.dungnv.android7pomodoro.SettingSharePref.Setting;
import com.example.dungnv.android7pomodoro.setting.SharedPreft;

public class SettinggActivity extends AppCompatActivity {
    private TextView tv_WordTime;
    private SeekBar sb_WordTime;
    private TextView tv_Break;
    private SeekBar sb_Break;
    private TextView tv_LongBreak;
    private SeekBar sb_LongBreak;
    private Spinner spinner;
    private Button defaul;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingg);

        tv_Break=(TextView)this.findViewById(R.id.tvBreak);
        sb_Break=(SeekBar)this.findViewById(R.id.sbBreak);
        tv_LongBreak=(TextView)this.findViewById(R.id.tvLongBreak);
        sb_LongBreak=(SeekBar)this.findViewById(R.id.sbLongBreak);
        tv_WordTime=(TextView)this.findViewById(R.id.tv_wordTime);
        sb_WordTime=(SeekBar)this.findViewById(R.id.sb_wordTime);
        spinner=(Spinner)this.findViewById(R.id.s_Break) ;
        defaul=(Button)this.findViewById(R.id.defaul);
        tv_Break.setText("Break :"+sb_Break.getProgress() +" minutes");
        tv_LongBreak.setText("Long Break :"+sb_LongBreak.getProgress()+" minutes");
        tv_WordTime.setText("Word Time :"+ sb_WordTime.getProgress()+" minutes");


        defaul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defaulSetting();
                tv_Break.setText("Break :"+sb_Break.getProgress() +" minutes");
                tv_LongBreak.setText("Long Break :"+sb_LongBreak.getProgress()+" minutes");
                tv_WordTime.setText("Word Time :"+ sb_WordTime.getProgress()+" minutes");
            }
        });
        sb_WordTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_WordTime.setText((String.format("Word Time :"+"%s"+" minutes", progress)));
               saveSetting();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
        sb_Break.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                tv_Break.setText((String.format("Break :"+"%s"+" minutes", progress)));
                saveSetting();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_LongBreak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_LongBreak.setText(String.format("Long Break :"+"%s"+" minutes",progress ));
                saveSetting();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

       String[] spin=new String[]{
               "1",
               "2",
               "3",
               "4",
               "5"
       };
        ArrayAdapter<String> array=new ArrayAdapter<>(
                this,android.R.layout.simple_spinner_dropdown_item,
                spin

        );
        spinner.setAdapter(array);
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               saveSetting();
               Log.e("Lưu",SharedPreft.getInstance().getSetting().toString() );
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
        Setting setting=SharedPreft.getInstance().getSetting();
        if (setting!=null) {
            sb_WordTime.setProgress(setting.getWorking());
            sb_Break.setProgress(setting.getBreak());
            sb_LongBreak.setProgress(setting.getLongBreak());
            spinner.setSelection(setting.getSpin());
        }
        else {
            defaulSetting();
        }

    }

    private void defaulSetting() {
        spinner.setSelection(0);
        sb_WordTime.setProgress(25);
        sb_LongBreak.setProgress(10);
        sb_Break.setProgress(5);
    }

    private void saveSetting() {
        SharedPreft.getInstance().put(new Setting(sb_WordTime.getProgress(),sb_Break.getProgress(),sb_LongBreak.getProgress(),spinner.getSelectedItemPosition()));
    }

}
