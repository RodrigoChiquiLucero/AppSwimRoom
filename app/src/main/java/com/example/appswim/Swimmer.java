package com.example.appswim;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "swimmer")
public class Swimmer {
    public String m_first_name;
    public String m_last_name;
    public String m_genre;
    @PrimaryKey
    @NonNull
    private String phoneNumber;
    public String m_age;
    public String m_height;
    public String m_weight;
    public String m_team;

    @NonNull
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirst_name(){
        return m_first_name;
    }

    public String getLast_name(){
        return m_last_name;
    }

    public String getGenre() {
        return m_genre;
    }

    public String getAge() {
        return m_age;
    }

    public String getHeight(){
        return m_height;
    }

    public String getWeight(){ return m_weight; }

    public String getTeam() { return m_team; }

    public void setFirst_name(String first_name){ m_first_name = first_name; }

    public void setPhoneNumber(@NonNull String phoneNumber) { this.phoneNumber = phoneNumber;}

    public void setLast_name(String last_name) { m_last_name = last_name; }

    public void setGenre(String genre){ m_genre = genre; }

    public void setAge(String age){ m_age = age; }

    public void setWeight(String weight){ m_weight = weight; }

    public void setHeight(String height){ m_height = height; }

    public void setTeam(String team){ m_team = team; }
}
