package com.example.brianofrim.juqe;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jferris on 28/01/17.
 */

public class SongListAdapter extends ArrayAdapter<Song> {

    private Context context;
    private ArrayList<Song> songList = new ArrayList<>();


    public SongListAdapter(Context context, ArrayList<Song> songList) {
        super(context, 0, songList);
        this.context = context;
        this.songList = songList;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.song_list_item, parent, false);
        }
        TextView songName = (TextView) convertView.findViewById(R.id.songName);
        TextView songArtist = (TextView) convertView.findViewById(R.id.songArtist);
        ImageButton upvoteButton = (ImageButton) convertView.findViewById(R.id.upvote_button);
        upvoteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                songList.get(position).incrementVotes();
                notifyDataSetChanged();
            }
            //RelativeLayout listItem = (RelativeLayout) v.getParent();
            //listItem.setBackgroundColor(ContextCompat.getColor(context, R.color.
        });

        Song song = getItem(position);
        //Set color for completion

        songName.setText(song.getName());
        songArtist.setText(song.getArtist());
        return convertView;

    }
}
