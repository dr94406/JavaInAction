package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static domain.Dish.Type.FISH;
import static domain.Dish.Type.MEAT;
import static java.util.stream.Collectors.toList;

public class StreamEx {
    public static void main(String[] args) {
         List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, MEAT),
            new Dish("beef", false, 700, MEAT),
            new Dish("chicken", false, 400, MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350,  Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300,FISH),
            new Dish("salmon", false, 450,FISH));

    List<String> threeHighCaloricDishNames =
            menu.stream()
                    .filter(dish -> dish.getCalories() > 300)
                    .map(Dish::getName)
                    .limit(3)
                    .collect(toList());

        System.out.println(threeHighCaloricDishNames);
        /** Collection : external iteration **/
        List<String> names = new ArrayList<>();
        for(Dish dish : menu) {
            names.add(dish.getName());
        }

        /** Stream : internal iteration **/
        List<String> nameS = menu.stream()
                .map(Dish::getName)
                .collect(toList());

        List<String> named =
            menu.stream()
                    .filter(dish -> {
                        System.out.println("filtering: " + dish.getName());
                        return dish.getCalories() > 300;
                })
                    .map(dish -> {
                        System.out.println("mapping:" + dish.getName());
                        return dish.getName();
                    })
                    .limit(3)
                    .collect(toList());
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
