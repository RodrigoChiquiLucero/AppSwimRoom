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
        public void addRace(Races... race);

        @Delete
        public void deleteSwimmer(Races race);


        @Query("SELECT * FROM races")
        public List<RacesDao> getRaces();

        @Query("SELECT * FROM races WHERE id_races = :id")
        public Races getRacesID(Integer id);

}
