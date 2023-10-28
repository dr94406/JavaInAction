import domain.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Runnable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static domain.Color.GREEN;
import static domain.Color.RED;
import static domain.Predicate.filter;
import static java.util.stream.Collectors.*;

public class main{
    private static List<Apple> inventory;

    public static List<Apple> filterApples (List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List <Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }


    public String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }

    }






    public void main(String[] args) throws IOException {
        List<Apple> heavyApples = inventory.stream().filter((Apple a) -> a.getWeight() > 150).collect(toList());

        List<Apple> heavyApples2 = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150).collect(toList());

        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());

        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
        public boolean test(Apple apple) {return RED.equals(apple.getColor());}});

        List<Apple> result = filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));

        List<Apple> redApple = filter(inventory, (Apple apple) -> RED.equals(apple.getColor()));

        Thread t = new Thread(() -> System.out.println("Hello World!"));

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> threadName = executorService.submit(() -> Thread.currentThread().getName());

        List<Apple> greenApples = filter(inventory, (Apple a) -> GREEN.equals(a.getColor()));

        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }
}
