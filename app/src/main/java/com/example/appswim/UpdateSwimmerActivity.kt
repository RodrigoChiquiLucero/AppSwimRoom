package com.example.appswim

import android.app.Activity
import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.example.appswim.database.SwimmerDao
import com.example.appswim.database.SwimmerDatabase
import com.example.appswim.models.Swimmer

class UpdateSwimmerActivity : AppCompatActivity() {

    companion object {
        val EXTRA_SWIMMER_ID = "id"
    }
    private var mFirstNameEditText: EditText? = null
    private var mLastNameEditText: EditText? = null
    private var mNationalityEditText: EditText? = null
    private var mPhoneNumberEditText: EditText? = null
    private var mGenreEditText: EditText? = null
    private var mAgeEditText: EditText? = null
    private var mHeightEditText: EditText? = null
    private var mWeightEditText: EditText? = null
    private var mTeamEditText: EditText? = null

    private var mToolbar: Toolbar? = null
    private var mUpdateButton: Button? = null
    private var mSwimmerDAO: SwimmerDao? = null
    private var SWIMMER: Swimmer? = null

    override fun onCreate(SavedInstanceState: Bundle?) {
        super.onCreate(SavedInstanceState)
        setContentView(R.layout.activity_update_swimmer)

        mSwimmerDAO = Room.databaseBuilder<SwimmerDatabase>(this, SwimmerDatabase::class.java, "db-swimmer")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .swimmerDao

        mFirstNameEditText = findViewById(R.id.firstNameEditText)
        mLastNameEditText = findViewById(R.id.lastNameEditText)
        mNationalityEditText = findViewById(R.id.nationalityEditText)
        mPhoneNumberEditText = findViewById(R.id.phoneNumberEditText)
        mGenreEditText = findViewById(R.id.genreEditText)
        mAgeEditText = findViewById(R.id.ageEditText)
        mUpdateButton = findViewById(R.id.updateButton)
        mHeightEditText = findViewById(R.id.heightEditText)
        mWeightEditText = findViewById(R.id.weightEditText)
        mTeamEditText = findViewById(R.id.teamEditText)

        mToolbar = findViewById(R.id.toolbar)

        SWIMMER = mSwimmerDAO!!.getSwimmerID(intent.getIntExtra(EXTRA_SWIMMER_ID,0))

        initViews()
    }

    private fun initViews() {

        setSupportActionBar(mToolbar)

        mFirstNameEditText!!.setText(SWIMMER!!.FirstName)
        mLastNameEditText!!.setText(SWIMMER!!.LastName)
        mNationalityEditText!!.setText(SWIMMER!!.Nationality)
        mPhoneNumberEditText!!.setText(SWIMMER!!.PhoneNumber)
        mGenreEditText!!.setText(SWIMMER!!.Genre)
        mAgeEditText!!.setText(SWIMMER!!.Age)
        mHeightEditText!!.setText(SWIMMER!!.Height)
        mWeightEditText!!.setText(SWIMMER!!.Weight)
        mTeamEditText!!.setText(SWIMMER!!.Team)

        mUpdateButton!!.setOnClickListener(View.OnClickListener {
            val FirstName = mFirstNameEditText!!.text.toString()
            val LastName = mLastNameEditText!!.text.toString()
            val Nationality = mNationalityEditText!!.text.toString()
            val PhoneNumber = mPhoneNumberEditText!!.text.toString()
            val Genre = mGenreEditText!!.text.toString()
            val Age = mAgeEditText!!.text.toString()
            val Height = mHeightEditText!!.text.toString()
            val Weight = mWeightEditText!!.text.toString()
            val Team = mTeamEditText!!.text.toString()

            if (FirstName.length == 0 || LastName.length == 0 || PhoneNumber.length == 0
                    || Genre.length == 0 || Age.length == 0 || Height.length == 0 || Weight.length == 0 ||
                    Team.length == 0) {
                Toast.makeText(this@UpdateSwimmerActivity, "Please make sure all details are correct", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            SWIMMER!!.FirstName = FirstName
            SWIMMER!!.LastName = LastName
            SWIMMER!!.Nationality = Nationality
            SWIMMER!!.PhoneNumber = PhoneNumber
            SWIMMER!!.Genre = Genre
            SWIMMER!!.Age = Age
            SWIMMER!!.Height = Height
            SWIMMER!!.Weight = Weight
            SWIMMER!!.Team = Team

            mSwimmerDAO!!.updateSwimmer(SWIMMER)
            setResult(Activity.RESULT_OK)
            finish()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_update_options, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete -> {
                mSwimmerDAO!!.deleteSwimmer(SWIMMER)
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}