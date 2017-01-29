package com.example.brianofrim.juqe;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by brianofrim on 2017-01-28.
 */

public class VenueController {

    private static DatabaseReference mDatabase;

    private static Venue currVenue;
    private static SongList songList;
    private static ArrayList<String> uriList = new ArrayList<>();

    public static DatabaseReference getDbRef(){
        if(mDatabase == null){
            mDatabase = FirebaseDatabase.getInstance().getReference();
        }
        return mDatabase;
    }


//    public static boolean venueCodeExists(String venueCode){
//
//        final String  venCode = venueCode;
//        final Boolean exists;
//        getDbRef().child("venues").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                exists = snapshot.hasChild(venCode);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//
//            }
//        });
//
//
//        return true;
//    }

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
        DatabaseReference dbr = getDbRef().child("songLists").child(songList.getVenueName()).child("songPool").push();
        s.setHash(dbr.getKey());
        dbr.setValue(s);
        songList.addSong(s);
    }

    public static void removeSong(Song s){
        getDbRef().child("songLists").child(songList.getVenueName()).child("songPool").child(s.getHash()).removeValue();
        songList.removeSong(s);
    }

    public static ArrayList<String> getURIList() {
        return uriList;
    }

    public static void addURI(String uri) {
        uriList.add(uri);
    }

    public static void removeURI(String uri) {
        uriList.remove(uri);
    }
}
