package com.example.appswim;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;


@Entity(tableName = "swimmer")
public class Swimmer {
    @PrimaryKey
    @NonNull
    private String mId;
    public String m_first_name;
    public String m_last_name;
    public String m_genre;
    public int m_age;
    public int m_height;
    public int m_weight;
    public String m_team;

    public Swimmer(){
        mId = UUID.randomUUID().toString();
    }

    @NonNull
    public String getId(){
        return mId;
    }

    public void setId(@NonNull String id){
        mId = id;
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

    public int getAge() {
        return m_age;
    }
    public int getHeight(){
        return m_height;
    }

    public int getWeight(){
        return m_weight;
    }

    public String getTeam() {
        return m_team;
    }

    public void setFirst_name(String first_name){
        m_first_name = first_name;
    }
    public void setLast_name(String last_name){
        m_last_name = last_name;
    }
    public void setGenre(String genre){
        m_genre = genre;
    }
    public void setAge(int age){
        m_age = age;
    }
    public void setWeight(int weight){
        m_weight = weight;
    }
    public void setHeight(int height){
        m_height = height;
    }
    public void setTeam(String team){
        m_team = team;
    }
}
