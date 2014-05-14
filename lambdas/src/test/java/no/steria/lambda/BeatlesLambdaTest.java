package no.steria.lambda;

import org.fest.assertions.Assertions;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class BeatlesLambdaTest {
    private BeatlesLambda beatlesLambda = new BeatlesLambda();

    @Test
    public void shouldFindAllAlbums() throws Exception {
        assertThat(Beatles.allAlbums()).hasSize(13);
    }

    @Test
    public void shouldListTitleOnAlbum() throws Exception {
        List<String> titleList = beatlesLambda.titleList("Help");
        assertThat(titleList).containsExactly(
        "Help!",
        "The Night Before",
        "You've Got to Hide Your Love Away",
        "I Need You",
        "Another Girl",
        "You're Going to Lose That Girl",
        "Ticket to Ride",
        "Act Naturally",
        "It's Only Love",
        "You Like Me Too Much",
        "Tell Me What You See",
        "I've Just Seen a Face",
        "Yesterday",
        "Dizzy Miss Lizzy"
        );
    }

    @Test
    public void shouldFindLengthOfAlbum() throws Exception {
        assertThat(beatlesLambda.albumLength("Please please me")).isEqualTo(1948);
    }

    @Test
    public void shouldFindTitlesWithLengthGreaterThan() throws Exception {
        assertThat(beatlesLambda.songsLongerThan(Beatles.album("Please please me").getSongs(),150))
                .containsExactly(
                        "I Saw Her Standing There", "Anna (Go to Him)", "Baby It's You", "Twist and Shout"
                );

    }

    @Test
    public void shouldFindTotalLength() throws Exception {
        // Hint: flatmap
        assertThat(beatlesLambda.totalLength(Beatles.allAlbums())).isEqualTo(29996);

    }

    @Test
    public void shouldFindNameAndLength() throws Exception {
        assertThat(beatlesLambda.longestTitleStaringWith(Beatles.allAlbums(),"A")).isEqualTo("A Day in the Life : 339 seconds");
        assertThat(beatlesLambda.longestTitleStaringWith(Beatles.allAlbums(),"X")).isEqualTo("None found");

    }

    // Extra (write test for yourself):
    // Which album is longest?
    // Which album has fewest songs
    // Which album has the highest avarage song length
    // Sort all titles by first letter and then length
}
