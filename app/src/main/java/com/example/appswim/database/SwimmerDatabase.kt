package com.example.appswim.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import com.example.appswim.models.Swimmer

@Database(entities = [Swimmer::class], version = 1)
abstract class SwimmerDatabase : RoomDatabase() {
    abstract val swimmerDao: SwimmerDao
}
