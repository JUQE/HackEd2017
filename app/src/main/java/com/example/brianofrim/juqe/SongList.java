package com.example.brianofrim.juqe;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SNIHostName;

/**
 * Created by brianofrim on 2017-01-28.
 */

public class SongList {


    private String venueCode;
    private List<Song> songPool;

    SongList(){
    }

    SongList(String venueN){
        this.venueCode = venueN;
        this.songPool = new ArrayList<Song>();
    }

    public List<Song> getSongPool() {
        return songPool;
    }

    public void setSongPool(List<Song> songPool) {
        this.songPool = songPool;
    }

    public String getVenueName() {
        return venueCode;
    }

    public void setVenueName(String venueName) {
        this.venueCode = venueName;
    }


}
