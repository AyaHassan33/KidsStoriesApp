package com.example.kidsstories;

import android.app.Activity;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StoriesAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<StoriesDetails> details;

    public StoriesAdapter(Activity activity, ArrayList<StoriesDetails> details) {
        this.activity = activity;
        this.details = details;
    }

    @Override
    public int getCount() {
        return details.size();
    }

    @Override
    public Object getItem(int position) {
        return details.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        v=inflater.inflate(R.layout.list_items,parent,false);
        ImageView iv=(ImageView) v.findViewById(R.id.image_view);
        TextView tv =(TextView)v.findViewById(R.id.text_view);
        iv.setImageResource(details.get(position).getPicture());
        tv.setText(details.get(position).getStoryName());


        return v;
    }
}
