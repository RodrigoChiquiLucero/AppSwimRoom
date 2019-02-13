package com.example.appswim.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.appswim.Swimmer;

import java.util.List;

@Dao
public interface SwimmerDao {

    @Query("SELECT * FROM swimmer")
    List<Swimmer>getSwimmer();

    @Query("SELECT * FROM swimmer WHERE mId = :id")
    public Swimmer getSwimmerID(String id);


    @Insert
    public void addSwimmer(Swimmer... swim);

    @Delete
    public void deleteSwimmer(Swimmer swim);

    @Update
    public void updateSwimmer(Swimmer... swim);



}
