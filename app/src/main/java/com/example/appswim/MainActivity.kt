package com.example.appswim

import android.app.Activity
import android.arch.persistence.room.Room
import android.content.Intent
import android.support.design.widget.FloatingActionButton
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button

import com.example.appswim.database.SwimmerDao
import com.example.appswim.database.SwimmerDatabase
import com.example.appswim.SwimmerActivity
import com.example.appswim.CreateSwimmerActivity
import com.example.appswim.SwimmerRecyclerAdapter




class MainActivity : AppCompatActivity() {

    private var mAddSwimmerButton: Button? = null
    private var mSwimmerDao: SwimmerDao? = null

    private val RC_LIST_SWIMMER = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSwimmerDao = Room.databaseBuilder(this,
                SwimmerDatabase::class.java, "db-swimmer")
                .allowMainThreadQueries()
                .build()
                .swimmerDao

        mAddSwimmerButton = findViewById(R.id.addSwimmerButton)

        mAddSwimmerButton!!.setOnClickListener {
            val intent = Intent(this@MainActivity, SwimmerActivity::class.java)
            startActivityForResult(intent, RC_LIST_SWIMMER)
        }
    }

}

