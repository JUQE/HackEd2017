package com.example.brianofrim.juqe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

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
        Song newSong = new Song("Mr. Brightside", "The Killers", "aadghghj41203498", 0);
        songArray.add(newSong);
        songAdapter = new SongListAdapter(this, songArray);
        songList.setAdapter(songAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
