package com.example.appswim.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "swimmer")
data class Swimmer (
    @PrimaryKey(autoGenerate = true)
    var id_swimmer: Int = 0,
    var FirstName: String,
    var LastName: String,
    var Genre: String,
    var PhoneNumber: String,
    var Age: String,
    var Height: String,
    var Weight: String,
    var Team: String
)

