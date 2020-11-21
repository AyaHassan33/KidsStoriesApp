package com.example.kidsstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class SplachScreeen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screeen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent =new Intent(SplachScreeen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);


    }
}