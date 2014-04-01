package no.steria.lambda;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Beatles {
    private static Beatles instance = init();

    private List<Album> beatlesAlbums = new ArrayList<>();

    private static Beatles init() {
        return new Beatles();
    }

    private Beatles() {
        InputStream is = Beatles.class.getClassLoader().getResourceAsStream("beatles.txt");
        String filestr;
        try {
            filestr = toString(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Song> current = null;

        for (String line : filestr.split("\n")) {
            if (line.startsWith("*")) {
                current = new ArrayList<>();
                beatlesAlbums.add(new Album(line.substring(1), current));
                continue;
            }
            String[] lineParts = line.split(";");
            String[] time = lineParts[1].split(":");
            int minutes = Integer.parseInt(time[0]);
            int seconds = Integer.parseInt(time[1]);

            current.add(new Song(lineParts[0],minutes*60+seconds));
        }
    }


    public static List<Album> allAlbums() {
        return instance.beatlesAlbums;
    }

    public static Album album(String name) {
        // Yes - this is done in java 7 on purpose :-)
        if (name == null) {
            return null;
        }
        for (Album album : instance.beatlesAlbums) {
            if (name.equals(album.getName())) {
                return album;
            }
        }
        return null;
    }


    private static String toString(InputStream inputStream) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"))) {
            StringBuilder result = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                result.append((char)c);
            }
            return result.toString();
        }
    }
}
