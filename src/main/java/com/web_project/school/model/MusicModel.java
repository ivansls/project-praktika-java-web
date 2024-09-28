package com.web_project.school.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class MusicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Size(max = 15, message = "name size error")
    private String Name;
    private String Author;
    @Nullable
    private String Album;

    public MusicModel(){}


    public MusicModel(Long id, String name, String author, @Nullable String album) {
        Id = id;
        Name = name;
        Author = author;
        Album = album;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public @Size(max = 15, message = "name size error") String getName() {
        return Name;
    }

    public void setName(@Size(max = 15, message = "name size error") String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    @Nullable
    public String getAlbum() {
        return Album;
    }

    public void setAlbum(@Nullable String album) {
        Album = album;
    }
}
