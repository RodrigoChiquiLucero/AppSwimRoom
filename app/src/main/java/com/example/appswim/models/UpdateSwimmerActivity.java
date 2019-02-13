package com.example.appswim.models;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appswim.R;
import com.example.appswim.Swimmer;
import com.example.appswim.database.SwimmerDao;
import com.example.appswim.database.SwimmerDatabase;

public class UpdateSwimmerActivity extends AppCompatActivity {

    public static String EXTRA_SWIMMER_ID = "swimmer_id";
    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;
    private EditText mGenreEditText;
    private EditText mAgeEditText;
    private EditText mHeightEditText;
    private EditText mWeightEditText;
    private EditText mTeamEditText;
    private Toolbar mToolbar;
    private Button mUpdateButton;
    private SwimmerDao mSwimmerDAO;
    private Swimmer SWIMMER;

    @Override

    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_update_swimmer);

        mSwimmerDAO = Room.databaseBuilder(this, SwimmerDatabase.class, "db-swimmer")
                .allowMainThreadQueries()
                .build()
                .getswimmerDao();

        mFirstNameEditText = findViewById(R.id.firstNameEditText);
        mLastNameEditText = findViewById(R.id.lastNameEditText);
        mGenreEditText = findViewById(R.id.genreEditText);
        mAgeEditText = findViewById(R.id.ageEditText);
        mUpdateButton = findViewById(R.id.updateButton);
        mHeightEditText = findViewById(R.id.heightEditText);
        mWeightEditText = findViewById(R.id.weightEditText);
        mTeamEditText = findViewById(R.id.teamEditText);

        mToolbar = findViewById(R.id.toolbar);

        SWIMMER = mSwimmerDAO.getSwimmerID(getIntent().getStringExtra(EXTRA_SWIMMER_ID));

        initViews();
    }

    private void initViews() {

        setSupportActionBar(mToolbar);

        mFirstNameEditText.setText(SWIMMER.getFirst_name());
        mLastNameEditText.setText(SWIMMER.getLast_name());
        mGenreEditText.setText(SWIMMER.getGenre());
        mAgeEditText.setText(SWIMMER.getAge());
        mHeightEditText.setText(SWIMMER.getHeight());
        mWeightEditText.setText(SWIMMER.getWeight());
        mTeamEditText.setText(SWIMMER.getTeam());

        mUpdateButton.setOnClickListener(new View.OnClickListener() {
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
                        m_team.length() == 0) {
                    Toast.makeText(UpdateSwimmerActivity.this, "Please make sure all details are correct", Toast.LENGTH_SHORT).show();
                    return;
                }

                SWIMMER.setFirst_name(m_first_name);
                SWIMMER.setLast_name(m_last_name);
                SWIMMER.setGenre(m_genre);
                SWIMMER.setAge(m_age);
                SWIMMER.setHeight(m_height);
                SWIMMER.setWeight(m_weight);
                SWIMMER.setTeam(m_team);

                //Insertar en la bd

                mSwimmerDAO.updateSwimmer(SWIMMER);
                setResult(RESULT_OK);
                finish();
            }
        });
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_update_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete: {
                mSwimmerDAO.deleteSwimmer(SWIMMER);
                setResult(RESULT_OK);
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    */
}