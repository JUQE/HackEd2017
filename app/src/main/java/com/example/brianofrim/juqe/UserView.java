package com.example.brianofrim.juqe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UserView extends Activity {
    private ArrayList<Song> songArray = new ArrayList<>();
    private SongListAdapter songAdapter;
    private ListView songList;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_view);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            code = extras.getString("code");
        }

        songList = (ListView) findViewById(R.id.allSongs);
        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            }
        });


    }


    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Song newSong = new Song("11", "The Killers", "aadghghj41203498", 11);
        songArray.add(newSong);
        newSong = new Song("100", "The Killers", "aadghghj41203498", 100);
        songArray.add(newSong);
        newSong = new Song("0", "The Killers", "aadghghj41203498", 0);
        songArray.add(newSong);
        newSong = new Song("10", "The Killers", "aadghghj41203498", 10);
        songArray.add(newSong);
        Collections.sort(songArray);
        songAdapter = new SongListAdapter(this, songArray);
        songList.setAdapter(songAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
