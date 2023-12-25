package domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class finalOperation {
    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1, 5, 6, 7, 8, 9,10);
        System.out.println(integerStream.count());
        System.out.println(integerStream.collect(Collectors.toList()));
        integerStream.forEach(System.out::println);
    }
}
