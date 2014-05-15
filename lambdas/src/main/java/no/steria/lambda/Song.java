package no.steria.lambda;

public class Song {
    private String name;
    private int length;
    private Album album;

    public Song(String name, int length, Album album) {
        this.name = name;
        this.length = length;
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public Album getAlbum() {
        return album;
    }
}
