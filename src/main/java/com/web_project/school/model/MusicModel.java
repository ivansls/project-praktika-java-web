package com.web_project.school.model;

public class MusicModel {
    private int Id;
    private String Name;
    private String Author;
    private String Album;


    public MusicModel(int id, String name, String author, String album) {
        Id = id;
        Name = name;
        Author = author;
        Album = album;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }
}
