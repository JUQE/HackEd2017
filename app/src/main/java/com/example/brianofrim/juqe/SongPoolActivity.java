package com.example.brianofrim.juqe;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

import java.util.ArrayList;

public class SongPoolActivity extends Activity {


    //UI elements
    private ListView songPoolLV;
    private SongPoolAdapter poolAdapter;
    private Song nowPlaying;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_pool2);
        songPoolLV = (ListView) findViewById(R.id.songPoolListView);


        ValueEventListener nowPlayingListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null) {
                    nowPlaying = dataSnapshot.getValue(Song.class);
                }
                imageView = (ImageView) findViewById(R.id.albumImage);

                if(imageView != null) {
                    new ImageDownloaderTask(imageView).execute(nowPlaying.getAlbumArt());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        VenueController.getDbRef().child("songLists").child(VenueController.getCurrVenue().getCode()).child("nowPlaying")
                .addValueEventListener(nowPlayingListener);
    }


    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        poolAdapter = new SongPoolAdapter(this, (ArrayList<Song>) VenueController.getCurrSongList().getSongPool());
        songPoolLV.setAdapter(poolAdapter);
    }

    public static void update() {

    }
}
