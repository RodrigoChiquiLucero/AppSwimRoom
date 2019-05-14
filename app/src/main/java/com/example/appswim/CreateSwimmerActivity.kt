package com.example.appswim


import android.app.Activity
import android.app.DatePickerDialog
import android.arch.persistence.room.Room
import android.database.sqlite.SQLiteConstraintException
import android.icu.util.Calendar
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.example.appswim.database.SwimmerDao
import com.example.appswim.database.SwimmerDatabase
import com.example.appswim.models.Swimmer
import kotlinx.android.synthetic.main.activity_create_swimmer.*


class CreateSwimmerActivity : AppCompatActivity() {

    private var mFirstNameEditText: EditText? = null
    private var mLastNameEditText: EditText? = null
    private var mPhoneNumberEditText: EditText? = null
    private var mGenreEditText: EditText? = null
    private var mHeightEditText: EditText? = null
    private var mWeightEditText: EditText? = null
    private var mTeamEditText: EditText? = null
    private var mSaveButton: Button? = null
    private var mSwimmerDao: SwimmerDao? = null

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_create_swimmer)

        // Calendario

        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)

        btnClickDate.setOnClickListener {
                val dpd = DatePickerDialog(this,android.R.style.Theme_Holo_Light_Dialog,
                    DatePickerDialog.OnDateSetListener{view, mYear,mMonth,
                                                       mDay->dateTv.text =
                            ("My birthday is "+mDay+"/"+mMonth + "/" + mYear)}, year,month,day)
            dpd.show()
        }

        mSwimmerDao = Room.databaseBuilder(this, SwimmerDatabase::class.java, "db-swimmer")
                .allowMainThreadQueries()
                .build()
                .swimmerDao

        mFirstNameEditText = findViewById(R.id.firstNameEditText)
        mLastNameEditText = findViewById(R.id.lastNameEditText)
        mGenreEditText = findViewById(R.id.genreEditText)
        mPhoneNumberEditText = findViewById(R.id.phoneNumberEditText)
        mHeightEditText = findViewById(R.id.heightEditText)
        mWeightEditText = findViewById(R.id.weightEditText)
        mTeamEditText = findViewById(R.id.teamEditText)
        mSaveButton = findViewById(R.id.saveButton)

        mSaveButton!!.setOnClickListener(View.OnClickListener {
            val FirstName = mFirstNameEditText!!.text.toString()
            val LastName = mLastNameEditText!!.text.toString()
            val Genre = mGenreEditText!!.text.toString()
            val PhoneNumber = mPhoneNumberEditText!!.text.toString()
            val Age = dateTv.text.toString()
            val Height = mHeightEditText!!.text.toString()
            val Weight = mWeightEditText!!.text.toString()
            val Team = mTeamEditText!!.text.toString()

            if(FirstName.length == 0){Toast.makeText(this@CreateSwimmerActivity,
                    "Please complete Firstname", Toast.LENGTH_SHORT).show()
                return@OnClickListener}
            else if(LastName.length == 0) {Toast.makeText(this@CreateSwimmerActivity,
                    "Please complete LastName", Toast.LENGTH_SHORT).show()
                return@OnClickListener}
            else if(PhoneNumber.length == 0){Toast.makeText(this@CreateSwimmerActivity,
                    "Please complete PhoneNumber", Toast.LENGTH_SHORT).show()
                return@OnClickListener}
            else if (Age.length == 0){Toast.makeText(this@CreateSwimmerActivity,
                    "Please select Age", Toast.LENGTH_SHORT).show()
                return@OnClickListener}
            else if(Height.length == 0){Toast.makeText(this@CreateSwimmerActivity,
                    "Please complete Height", Toast.LENGTH_SHORT).show()
                return@OnClickListener}
            else if(Weight.length == 0){Toast.makeText(this@CreateSwimmerActivity,
                    "Please complete Weight", Toast.LENGTH_SHORT).show()
                return@OnClickListener}
            else if(Team.length == 0){Toast.makeText(this@CreateSwimmerActivity,
                    "Please complete Team", Toast.LENGTH_SHORT).show()
                return@OnClickListener}

            val swimmer = Swimmer(
                    FirstName = FirstName,
                    LastName = LastName,
                    Genre = Genre,
                    PhoneNumber = PhoneNumber,
                    Age = Age,
                    Height = Height,
                    Weight = Weight,
                    Team = Team
            )

            try {
                mSwimmerDao!!.addSwimmer(swimmer)
                setResult(Activity.RESULT_OK)
                finish()
            } catch (e: SQLiteConstraintException) {
                Toast.makeText(this@CreateSwimmerActivity, "A swimmer already exists.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}



