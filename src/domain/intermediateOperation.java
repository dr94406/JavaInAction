package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class intermediateOperation {

    public static void main(String[] args) {

        // filter, map, distinct
        List<String> StringList = Arrays.asList("goo2","goo","chang","mo","min");
        System.out.println(StringList.stream().filter(s -> s.startsWith("g")).map(String::toUpperCase).distinct().collect(Collectors.toList()));

        //limit, sorted
        List<Integer> IntegerList = Arrays.asList(50, 52, 1, 2, 3, 5, 6, 7, 8, 9,10);
        System.out.println(IntegerList.stream().sorted().limit(10).collect(Collectors.toList()));


    }
}
