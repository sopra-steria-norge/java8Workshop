package no.steria.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleLambda {
    public List<Integer> doubleNumbers(List<Integer> numbers) {
        Stream<Integer> map = numbers.stream().map(num -> num * 2);
        return map.collect(Collectors.toList());
    }
}
