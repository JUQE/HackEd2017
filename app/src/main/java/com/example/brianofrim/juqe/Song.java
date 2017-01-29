package com.example.brianofrim.juqe;

/**
 * Created by jferris on 28/01/17.
 */


public class Song implements Comparable<Song>{
    private String name;
    private String artist;
    private String URI;
    private int votes;

    public Song (String name, String artist, String URI, int votes) {
        this.name = name;
        this.artist = artist;
        this.URI = URI;
        this.votes = votes;
    }

    public Song() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public void incrementVotes() {
        votes = votes + 1;
    }

    @Override
    public int compareTo(Song song) {
        return song.getVotes() - this.getVotes();
    }

    @Override
    public String toString() {
        return "Song = " + this.getName() + "Artist = " + this.getArtist();
    }
}
