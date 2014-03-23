package no.steria.lambda;

import org.fest.assertions.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class SimpleLambdaTest {
    @Test
    public void shouldDoubleListEntries() throws Exception {
        SimpleLambda simpleLambda = new SimpleLambda();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> doubles = simpleLambda.doubleNumbers(numbers);
        assertThat(doubles).containsExactly(2,4,6,8,10);
    }
}
