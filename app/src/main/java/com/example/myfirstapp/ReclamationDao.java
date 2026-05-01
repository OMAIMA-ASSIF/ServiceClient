package com.example.myfirstapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReclamationDao {

    @Insert
    void add(Reclamation reclamation);

    @Query("SELECT * FROM reclamations ORDER BY id DESC")
    List<Reclamation> getAll();



}
