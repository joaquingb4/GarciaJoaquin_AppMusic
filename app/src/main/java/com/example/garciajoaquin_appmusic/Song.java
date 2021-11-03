package com.example.garciajoaquin_appmusic;

public class Song {
    String name;
    String autor;
    String duration;

    public Song(String name, String autor, String duration){
        this.name = name;
        this.autor = autor;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }
    public String getAutor() {
        return autor;
    }

    public String getDuration() {
        return duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
