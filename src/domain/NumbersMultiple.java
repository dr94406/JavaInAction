package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersMultiple {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(numbers.stream().filter(x -> x% 2 == 0).map(s -> s * s).collect(Collectors.toList()));
    }
}
