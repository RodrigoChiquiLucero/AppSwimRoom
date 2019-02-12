package com.example.appswim.models;

import android.arch.persistence.room.Room;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appswim.R;
import com.example.appswim.Swimmer;
import com.example.appswim.database.SwimmerDao;
import com.example.appswim.database.SwimmerDatabase;


public class CreateSwimmerActivity extends AppCompatActivity {
    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;
    private EditText mGenreEditText;
    private EditText mAgeEditText;
    private EditText mHeightEditText;
    private EditText mWeightEditText;
    private EditText mTeamEditText;

    private Button mSaveButton;
    private SwimmerDao mSwimmerDao;

    @Override

    protected  void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_create_swimmer);

        mSwimmerDao = Room.databaseBuilder(this, SwimmerDatabase.class, "db-swimmer")
                .allowMainThreadQueries()
                .build()
                .getswimmerDao();

        mFirstNameEditText = findViewById(R.id.firstNameEditText);
        mLastNameEditText = findViewById(R.id.lastNameEditText);
        mGenreEditText = findViewById(R.id.genreEditText);
        mAgeEditText = findViewById(R.id.ageEditText);
        mHeightEditText = findViewById(R.id.heightEditText);
        mWeightEditText = findViewById(R.id.weightEditText);
        mTeamEditText = findViewById(R.id.teamEditText);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m_first_name = mFirstNameEditText.getText().toString();
                String m_last_name = mLastNameEditText.getText().toString();
                String m_genre = mGenreEditText.getText().toString();
                String m_age = mAgeEditText.getText().toString();
                String m_height = mHeightEditText.getText().toString();
                String m_weight = mWeightEditText.getText().toString();
                String m_team = mTeamEditText.getText().toString();

                if (m_first_name.length() == 0 || m_last_name.length() == 0 || m_genre.length() == 0
                || m_age.length() == 0 || m_height.length() == 0 || m_weight.length() == 0 ||
                        m_team.length() == 0){
                    Toast.makeText(CreateSwimmerActivity.this, "Please make sure all details are correct", Toast.LENGTH_SHORT).show();
                    return;
                }

                Swimmer swimmer = new Swimmer();
                swimmer.setFirst_name(m_first_name);
                swimmer.setLast_name(m_last_name);
                swimmer.setGenre(m_genre);
                swimmer.setAge(m_age);
                swimmer.setHeight(m_height);
                swimmer.setWeight(m_weight);
                swimmer.setTeam(m_team);

                try{
                    mSwimmerDao.addSwimmer(swimmer);
                    setResult(RESULT_OK);
                    finish();
                }catch (SQLiteConstraintException e) {
                    Toast.makeText(CreateSwimmerActivity.this, "A swimmer already exists.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

