package com.example.brianofrim.juqe;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by jferris on 28/01/17.
 */

public class SongListAdapter extends ArrayAdapter<Song> {

    private Context context;
    private ArrayList<Song> habitList = new ArrayList<>();


    public SongListAdapter(Context context, ArrayList<Song> habitList) {
        super(context, 0, habitList);
        this.context = context;
        this.habitList = habitList;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.song_list_item, parent, false);
        }
        TextView habitName = (TextView) convertView.findViewById(R.id.songItem);

        Song song = getItem(position);
        //Set color for completion

        habitName.setText(song.getName());

        return convertView;

    }
}
