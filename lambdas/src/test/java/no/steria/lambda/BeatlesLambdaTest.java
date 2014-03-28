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
}
