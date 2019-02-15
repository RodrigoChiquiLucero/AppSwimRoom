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


    @Insert
    public void addSwimmer(Swimmer... swim);

    @Update
    public void updateSwimmer(Swimmer... swim);

    @Delete
    public void deleteSwimmer(Swimmer swimmer);


    @Query("SELECT * FROM swimmer")
    public List<Swimmer>getSwimmer();

    @Query("SELECT * FROM swimmer WHERE phoneNumber = :number")
    public Swimmer getSwimmerID(String number);

}
