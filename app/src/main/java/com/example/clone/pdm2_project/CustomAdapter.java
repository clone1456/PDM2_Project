package com.example.clone.pdm2_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.clone.pdm2_project.Model.Speakers;

import java.util.List;

import info.androidhive.androidsplashscreentimer.R;

/**
 * Created by clone on 17-01-2018.
 */


public class CustomAdapter extends BaseAdapter {
    private List<Speakers> speakerList;
    private Context context;

    public CustomAdapter(Context context, List<Speakers> speakers) {
        this.context = context;
        this.speakerList = speakers;
    }

    @Override
    public int getCount() {
        return this.speakerList.size();
    }

    @Override
    public Speakers getItem(int position) {
        return this.speakerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= layoutInflater.inflate(R.layout.list_row, null);
        }

        Speakers speaker = getItem(position);

        assert convertView != null;
        TextView textView = (TextView) convertView.findViewById(R.id.title);
        textView.setText(speaker.getName());

        return convertView;
    }
}