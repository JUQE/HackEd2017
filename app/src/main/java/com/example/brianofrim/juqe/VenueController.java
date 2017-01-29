package com.example.brianofrim.juqe;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by brianofrim on 2017-01-28.
 */

public class VenueController {

    DatabaseReference mDatabase;

    private DatabaseReference getDbRef(){
        if(mDatabase == null){
            mDatabase = FirebaseDatabase.getInstance().getReference();
        }
        return mDatabase;
    }


    public boolean venueCodeExists(String venueCode){
        return true;
    }

    public void createVenue(String venueCode,String venueName){
        Venue newVenue = new Venue(venueName, venueCode);

        getDbRef().child("venues").child(newVenue.getCode()).setValue(newVenue);

    }
}
