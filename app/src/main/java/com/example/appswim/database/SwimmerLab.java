package com.example.appswim.database;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.appswim.Swimmer;

import java.util.List;

public class SwimmerLab {
    @SuppressLint("StaticFieldLeak")
    private static SwimmerLab sSwimmerLab;

    private SwimmerDao mSwimmerDao;

    private SwimmerLab(Context context) {
        Context appContext = context.getApplicationContext();
        SwimmerDatabase database = Room.databaseBuilder(appContext,SwimmerDatabase.class
                ,"swimmer")
                .allowMainThreadQueries().build();
        mSwimmerDao = database.swimmerDao();
    }

        public static SwimmerLab get(Context context){
            if (sSwimmerLab == null){
                sSwimmerLab = new SwimmerLab(context);
            }
            return sSwimmerLab;
        }

        public List<Swimmer>getSwimmer(){
            return mSwimmerDao.getSwimmer();
        }

        public Swimmer getSwimmer(String id){
            return mSwimmerDao.getSwimmer(id);
        }

        public void addSwimmer(Swimmer swimmer){
            mSwimmerDao.addSwimmer(swimmer);
        }

        public void updateSwimmer(Swimmer swimmer){
            mSwimmerDao.updateSwimmer(swimmer);
        }

        public void deleteSwimmer(Swimmer swimmer){
            mSwimmerDao.deleteSwimmer(swimmer);
        }
}
