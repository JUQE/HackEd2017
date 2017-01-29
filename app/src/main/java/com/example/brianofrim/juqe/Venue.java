package com.example.brianofrim.juqe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jferris on 28/01/17.
 */

public class Venue {
    private List<Song> songList;
    private String name;
    private String code;
    private Song nowPlaying;

    public Venue (String name, String code) {
        this.songList = new ArrayList<Song>();
        this.name = name;
        this.code = code;

    }

    public Venue () {
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(ArrayList<Song> songList) {
        this.songList = songList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



}
