package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class mapAndArraysStream {
    public static void main(String[] args) {
        String[] arrayOfWords = {"Goodbye", "World"};

        List<String> streamOfwords = Arrays.asList(arrayOfWords);

        System.out.println(streamOfwords.stream().map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct().collect(Collectors.toList()));

        //flatmap
        List<String> uniqueCharacters = streamOfwords.stream().map(word -> word.split("")).flatMap(Arrays::stream).sorted().distinct().collect(Collectors.toList());
        System.out.println(uniqueCharacters);
    }
}
