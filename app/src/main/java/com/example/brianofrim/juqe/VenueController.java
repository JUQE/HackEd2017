package com.example.brianofrim.juqe;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by brianofrim on 2017-01-28.
 */

public class VenueController {

    private static DatabaseReference mDatabase;

    private static Venue currVenue;
    private static SongList songList;

    private static DatabaseReference getDbRef(){
        if(mDatabase == null){
            mDatabase = FirebaseDatabase.getInstance().getReference();
        }
        return mDatabase;
    }


    public static boolean venueCodeExists(String venueCode){
        return true;
    }

    public static void createVenue(String venueCode,String venueName){
        Venue newVenue = new Venue(venueName, venueCode);
        SongList newSongList = new SongList(venueCode);

        getDbRef().child("venues").child(newVenue.getCode()).setValue(newVenue);
        getDbRef().child("songLists").child(newVenue.getCode()).setValue(newVenue);

        currVenue = newVenue;
        songList = newSongList;

    }

    public static Venue getCurrVenue(){
        return currVenue;
    }

    public static SongList getCurrSongList(){
        return songList;
    }

    public static void addSong(Song s){
        getDbRef().child("songLists").child(songList.getVenueName()).child("songPool").push().setValue(s);
    }
}
