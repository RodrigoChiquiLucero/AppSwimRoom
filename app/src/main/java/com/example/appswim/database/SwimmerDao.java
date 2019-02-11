package com.example.appswim.database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.appswim.Swimmer;

import java.util.List;

interface SwimmerDao {
    @Query("SELECT * FROM swimmer")
    List<Swimmer>getSwimmer();

    @Query("SELECT * FROM swimmer WHERE mId LIKE : uuid")
    Swimmer getSwimmer(String uuid);

    @Insert
    void addSwimmer(Swimmer swim);

    @Delete
    void deleteSwimmer(Swimmer swim);

    @Update
    void updateSwimmer(Swimmer swim);

}
