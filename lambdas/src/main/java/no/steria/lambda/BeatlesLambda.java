package no.steria.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BeatlesLambda {
    public List<String> titleList(String albumName) {
        List<Song> songs = Beatles.album(albumName).getSongs();
        Stream<String> titles = songs.stream().map(s -> s.getName());
        return titles.collect(Collectors.toList());
    }
}
