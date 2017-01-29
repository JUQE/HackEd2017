package com.example.brianofrim.juqe;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;

import org.w3c.dom.Comment;

import java.util.ArrayList;

public class SongPoolActivity extends Activity {


    //UI elements
    private ListView songPoolLV;

    private SongPoolAdapter poolAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_pool2);
        songPoolLV = (ListView) findViewById(R.id.songPoolListView);


    }


    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        poolAdapter = new SongPoolAdapter(this, (ArrayList<Song>) VenueController.getCurrSongList().getSongPool());
        songPoolLV.setAdapter(poolAdapter);
    }

}
