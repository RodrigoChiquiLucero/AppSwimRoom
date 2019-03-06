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

import com.example.appswim.database.SwimmerDao
import com.example.appswim.database.SwimmerDatabase
import com.example.appswim.models.Swimmer


import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    private var mSwimmerRecyclerView: RecyclerView? = null
    private var mSwimmerRecyclerAdapter: SwimmerRecyclerAdapter? = null
    private var mAddSwimmerFloatingActionButton: FloatingActionButton? = null
    private var mSwimmerDao: SwimmerDao? = null

    private val RC_CREATE_SWIMMER = 1
    private val RC_UPDATE_SWIMMER = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSwimmerDao = Room.databaseBuilder(this, SwimmerDatabase::class.java, "db-swimmer")
                .allowMainThreadQueries()
                .build()
                .swimmerDao

        mSwimmerRecyclerView = findViewById(R.id.swimmerRecyclerView)
        mSwimmerRecyclerView?.layoutManager = LinearLayoutManager(this)
        mAddSwimmerFloatingActionButton = findViewById(R.id.addSwimmerFloatingActionButton)

        val colors = intArrayOf(ContextCompat.getColor(this, R.color.colorAccent), ContextCompat.getColor(this, android.R.color.holo_red_light), ContextCompat.getColor(this, android.R.color.holo_orange_light), ContextCompat.getColor(this, android.R.color.holo_green_light), ContextCompat.getColor(this, android.R.color.holo_blue_dark), ContextCompat.getColor(this, android.R.color.holo_purple))

        mSwimmerRecyclerAdapter = SwimmerRecyclerAdapter(this, ArrayList(), colors)
        mSwimmerRecyclerAdapter?.addActionCallback(object : SwimmerRecyclerAdapter.ActionCallback {
            override fun onLongClickListener(swimmer: Swimmer) {

                val intent = Intent(this@MainActivity, UpdateSwimmerActivity::class.java)
                intent.putExtra(UpdateSwimmerActivity.EXTRA_SWIMMER_ID, swimmer.id_swimmer)
                startActivityForResult(intent, RC_UPDATE_SWIMMER)
            }
        })

        mSwimmerRecyclerView?.setAdapter(mSwimmerRecyclerAdapter)

        mAddSwimmerFloatingActionButton!!.setOnClickListener {
            val intent = Intent(this@MainActivity, CreateSwimmerActivity::class.java)
            startActivityForResult(intent, RC_CREATE_SWIMMER)
        }

        loadSwimmers()
    }

    private fun loadSwimmers() {
        mSwimmerRecyclerAdapter!!.updateData(mSwimmerDao!!.swimmer)
    }

    /*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_CREATE_SWIMMER && resultCode == Activity.RESULT_OK) {
            loadSwimmers()
        } else if (requestCode == RC_UPDATE_SWIMMER && resultCode == Activity.RESULT_OK) {
            loadSwimmers()
        }
    }
    */
}

