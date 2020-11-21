package com.example.kidsstories;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Stories extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        String story = getIntent().getStringExtra("storiesOfKids");
        TextView textView= (TextView)findViewById(R.id.txt1);
        String title=getIntent().getStringExtra("title");
        //setTitle(title);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        textView.setText(story);
        SharedPreferences preferences=getSharedPreferences("textFile",MODE_PRIVATE);
        int returnSize= preferences.getInt("textSize",20);
        textView.setTextSize(returnSize);
        ImageView image= (ImageView)findViewById(R.id.img1);
        int pic = getIntent().getIntExtra("picture",0);
        image.setImageResource(pic);
        int backGround = getIntent().getIntExtra("backOfStories",0);
        LinearLayout layout =(LinearLayout)findViewById(R.id.layout);
        layout.setBackground(getDrawable(backGround));


    }
}