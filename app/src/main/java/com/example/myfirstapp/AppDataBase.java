package com.example.myfirstapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Reclamation.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract ReclamationDao reclamationDao();
}
