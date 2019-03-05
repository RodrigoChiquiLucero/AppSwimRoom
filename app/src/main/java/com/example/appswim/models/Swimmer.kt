package com.example.appswim.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "swimmer")
data class Swimmer (
    var FirstName: String,
    val LastName: String,
    val Genre: String,
    @PrimaryKey
    val PhoneNumber: String,
    val Age: String,
    val Height: String,
    val Weight: String,
    val Team: String
)

