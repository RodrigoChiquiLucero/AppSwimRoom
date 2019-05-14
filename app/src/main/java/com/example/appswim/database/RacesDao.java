package com.example.appswim.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.appswim.models.Races;
import java.util.List;


@Dao
public interface RacesDao {

    @Insert
    public void addRace(Races ... race);

    @Update
    public void updateRace(Races race);

    @Delete
    public void deleteRace(Races race);

    @Query("SELECT * FROM races")
    public List<Races>getRaces();

    @Query("SELECT * FROM races WHERE id_race = :id")
    public Races getRacesID(Integer id);
}