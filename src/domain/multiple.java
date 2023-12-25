package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class multiple {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 8, 16);
        System.out.println(numbers.stream().map(n -> n * n).collect(Collectors.toList()));
    }
}
