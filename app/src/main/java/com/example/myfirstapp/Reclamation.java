package com.example.myfirstapp;

public class Reclamation {

    private String description;
    private String title;

    public Reclamation(String description, String title) {
        this.description = description;
        this.title= title;
    }

    public String getDescription(){
        return this.description;
    }
    public String getTitle() {
        return this.title;
    }
}
