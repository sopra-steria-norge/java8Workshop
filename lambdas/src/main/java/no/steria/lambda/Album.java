package no.steria.lambda;

import java.util.ArrayList;
import java.util.List;

// DO NOT EDIT THIS TO SOLVE TASKS
public class Album {
    private String name;
    private List<Song> songs = new ArrayList<>();

    public Album(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
