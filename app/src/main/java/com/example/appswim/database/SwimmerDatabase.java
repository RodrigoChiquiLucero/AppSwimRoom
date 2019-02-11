package com.example.appswim.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.appswim.Swimmer;

@Database(entities = {Swimmer.class},version = 1)
public abstract class SwimmerDatabase extends RoomDatabase {
    public abstract SwimmerDao swimmerDao();
}
