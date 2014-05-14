package no.steria.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BeatlesLambda {
    public List<String> titleList(String albumName) {
        List<Song> songs = Beatles.album(albumName).getSongs();
        Stream<String> titles = songs.stream().map(s -> s.getName());
        return titles.collect(Collectors.toList());
    }

    public int albumLength(String albumName) {
        List<Song> songs = Beatles.album(albumName).getSongs();
        return songs.stream().map(s -> s.getLength()).reduce(Integer::sum).orElse(0);
    }

    public List<String> songsLongerThan(List<Song> songs,final int length) {
        Stream<String> map = songs.stream().filter(s -> s.getLength() > length).map(s -> s.getName());
        return map.collect(Collectors.toList());
    }

    public int totalLength(List<Album> albums) {
        return albums.stream().flatMap(a -> a.getSongs().stream()).map(s -> s.getLength()).reduce(Integer::sum).orElse(0);
    }


    public String longestTitleStaringWith(List<Album> albums, final String start) {
        return albums.stream()
                .flatMap(a -> a.getSongs().stream())
                .filter(s -> s.getName().startsWith(start))
                .max(Comparator.comparing(Song::getLength))
                .map(s -> s.getName() + " : " + s.getLength() + " seconds")
                .orElse("None found");

    }
}
