package com.example.appswim;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;


import com.example.appswim.database.SwimmerDao;
import com.example.appswim.database.SwimmerDatabase;
import com.example.appswim.models.Swimmer;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int RC_CREATE_SWIMMER = 1;
    public static final int RC_UPDATE_SWIMMER = 2;

    private RecyclerView mSwimmerRecyclerView;
    private SwimmerRecyclerAdapter mSwimmerRecyclerAdapter;
    private FloatingActionButton mAddSwimmerFloatingActionButton;
    private SwimmerDao mSwimmerDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwimmerDao = Room.databaseBuilder(this, SwimmerDatabase.class, "db-swimmer")
                .allowMainThreadQueries()
                .build()
                .getSwimmerDao();

        mSwimmerRecyclerView = findViewById(R.id.swimmerRecyclerView);
        mSwimmerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAddSwimmerFloatingActionButton = findViewById(R.id.addSwimmerFloatingActionButton);

        int colors[] = {ContextCompat.getColor(this, R.color.colorAccent),
                ContextCompat.getColor(this, android.R.color.holo_red_light),
                ContextCompat.getColor(this, android.R.color.holo_orange_light),
                ContextCompat.getColor(this, android.R.color.holo_green_light),
                ContextCompat.getColor(this, android.R.color.holo_blue_dark),
                ContextCompat.getColor(this, android.R.color.holo_purple)};

        mSwimmerRecyclerAdapter = new SwimmerRecyclerAdapter(this,new ArrayList<Swimmer>(),colors);
        mSwimmerRecyclerAdapter.addActionCallback(new SwimmerRecyclerAdapter.ActionCallback() {
            @Override
            public void onLongClickListener(Swimmer swimmer) {
                Intent intent = new Intent(MainActivity.this,UpdateSwimmerActivity.class);
                intent.putExtra(UpdateSwimmerActivity.EXTRA_SWIMMER_ID,swimmer.getPhoneNumber());
                startActivityForResult(intent,RC_UPDATE_SWIMMER);
            }
        });

        mSwimmerRecyclerView.setAdapter(mSwimmerRecyclerAdapter);

        mAddSwimmerFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateSwimmerActivity.class);
                startActivityForResult(intent, RC_CREATE_SWIMMER);
            }
        });

        loadSwimmers();
    }

    private void loadSwimmers() {
        mSwimmerRecyclerAdapter.updateData(mSwimmerDao.getSwimmer());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_CREATE_SWIMMER && resultCode == RESULT_OK) {
            loadSwimmers();
        } else if (requestCode == RC_UPDATE_SWIMMER && resultCode == RESULT_OK) {
            loadSwimmers();
        }
    }
}

