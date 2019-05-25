package com.example.appswim.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

enum class Styles {
    Butterfly, //Mariposa
    BackStroke,// Espalda
    BreastStroke, // Pecho
    Freestyle; // Crol

    override fun toString(): String {
        return super.toString()
    }
}


@Entity(tableName ="races")
data class Races (
    @PrimaryKey(autoGenerate = true)
    var id_races: Int = 0,
    var distance : Int,
    var style: Styles,
    var time : Int,
    var place :String
)