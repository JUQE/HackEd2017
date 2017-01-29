package com.example.brianofrim.juqe;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

/**
 * Created by jferris on 28/01/17.
 */

public class UserController {

    private static DatabaseReference mDatabase;
    private static String code;

    private static DatabaseReference getDbRef(){

        if(mDatabase == null){
            mDatabase = FirebaseDatabase.getInstance().getReference();
        }
        return mDatabase;
    }


    public static boolean venueCodeExists(String venueCode){
        return true;
    }

    public static void upvoteSong(Song song){

        song.setVotes(song.getVotes() + 1);
        getDbRef().child("songLists").child(code).child("songPool").child(song.getHash()).child("votes").setValue(song.getVotes());


    }

    public static void setCode(String code) {

    }

}
