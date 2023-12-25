package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringLength {
    public static void main(String[] args) {


        List<String> words = Arrays.asList("Modern", "Java" ,"In", "Action");
        System.out.println(words.stream().map(String::length).collect(Collectors.toList()));

        var w = words.stream().map(word -> word.split("")).distinct().collect(Collectors.toList());
        System.out.println(w);

        List<String> uniqueCharacters = words.stream().map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCharacters);
    }
}
