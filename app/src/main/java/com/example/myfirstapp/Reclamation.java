package com.example.myfirstapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reclamations")

public class Reclamation {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;

    public Reclamation(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}