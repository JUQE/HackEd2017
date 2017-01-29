package com.example.brianofrim.juqe;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

public class SongPoolActivity extends Activity {


    //UI elements
    private ListView songPoolLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_pool2);


        songPoolLV = (ListView) findViewById(R.id.songPoolListView);



    }






}
