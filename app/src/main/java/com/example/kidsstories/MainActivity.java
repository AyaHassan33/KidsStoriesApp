package com.example.kidsstories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int[] sounds ={R.raw.rabbit_sound,R.raw.cow,R.raw.duck,R.raw.bee,R.raw.monkey_sound,R.raw.cat_sound};
    private int[] backGround ={R.drawable.rabbit_back,R.drawable.cow_back,R.drawable.duck_back,R.drawable.bee_back,R.drawable.monkey_back,R.drawable.cat_back};
    //private String[] stories={getString(R.string.rabbit_story), getString(R.string.cow_story), getString(R.string.duck_story), getString(R.string.bee_story), getString(R.string.monkey_story), getString(R.string.cat_story)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        final ArrayList<StoriesDetails> storiesDetails= new ArrayList<>();
        storiesDetails.add(new StoriesDetails(R.drawable.rabbit,getString(R.string.stor_rabbit_name),R.drawable.the_rabbit,getString(R.string.rabbit_story)));
        storiesDetails.add(new StoriesDetails(R.drawable.cow,getString(R.string.stor_cow_name),R.drawable.lazy_cow,getString(R.string.cow_story)));
        storiesDetails.add(new StoriesDetails(R.drawable.duck,getString(R.string.stor_duck_name),R.drawable.ungly_duck,getString(R.string.duck_story)));
        storiesDetails.add(new StoriesDetails(R.drawable.bee,getString(R.string.stor_bee_name),R.drawable.beeandloust, getString(R.string.bee_story)));
        storiesDetails.add(new StoriesDetails(R.drawable.monkey,getString(R.string.stor_monkey_name),R.drawable.monkeyandturtle,getString(R.string.monkey_story)));
        storiesDetails.add(new StoriesDetails(R.drawable.cat,getString(R.string.stor_cat_name),R.drawable.ungry_cat, getString(R.string.cat_story)));
        StoriesAdapter adapter= new StoriesAdapter(this,storiesDetails);
        ListView lv =(ListView)findViewById(R.id.list_view);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer mediaPlayer=MediaPlayer.create(MainActivity.this,sounds[position]);
                mediaPlayer.start();
                Intent intent = new Intent(MainActivity.this,Stories.class);
                intent.putExtra("storiesOfKids",storiesDetails.get(position).getStories());
                intent.putExtra("title",storiesDetails.get(position).getStoryName());
                intent.putExtra("picture",storiesDetails.get(position).getImageStory());
                intent.putExtra("backOfStories",backGround[position]);
                startActivity(intent);

            }
        });
        final Button btnSettings = (Button)findViewById(R.id.btn_setting);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Settings.class);
                intent.putExtra("titleSet",btnSettings.getText());

                startActivity(intent);

            }
        });


    }
}