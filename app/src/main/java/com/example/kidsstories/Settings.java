package com.example.kidsstories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioGroup;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        String title = getIntent().getStringExtra("titleSet");
       // setTitle(title);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.RG);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.RB1:
                        SharedPreferences.Editor editor=getSharedPreferences("textFile",MODE_PRIVATE).edit();
                        editor.putInt("textSize",16);
                        editor.apply();
                        break;
                    case R.id.RB2:
                        SharedPreferences.Editor editor1=getSharedPreferences("textFile",MODE_PRIVATE).edit();
                        editor1.putInt("textSize",32);
                        editor1.apply();
                        break;
                    case R.id.RB3:
                        SharedPreferences.Editor editor2=getSharedPreferences("textFile",MODE_PRIVATE).edit();
                        editor2.putInt("textSize",42);
                        editor2.apply();
                        break;
                }
            }
        });
    }
}