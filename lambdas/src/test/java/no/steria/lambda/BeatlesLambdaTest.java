package no.steria.lambda;

import org.fest.assertions.Assertions;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class BeatlesLambdaTest {
    @Test
    public void shouldFindAllAlbums() throws Exception {
        assertThat(Beatles.allAlbums()).hasSize(13);

    }
}
