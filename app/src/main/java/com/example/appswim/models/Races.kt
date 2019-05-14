package com.example.appswim.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.text.DateFormat
import java.util.*

enum class Styles(){
    Butterfly,Backstroke,Breaststroke,Freestyle;

    override fun toString(): String{
        return super.toString()
    }
}



@Entity(tableName = "races")
data class Races (
        @PrimaryKey(autoGenerate = true)
        var id_race: Int = 0,
        var place : String,
        var date : Date,
        var time : Date,
        var Style: Styles
)