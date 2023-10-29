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

        /** Collection : external iteration **/
        List<String> names = new ArrayList<>();
        for(Dish dish : menu) {
            names.add(dish.getName());
        }

        /** Stream : internal iteration **/
        List<String> nameS = menu.stream()
                .map(Dish::getName)
                .collect(toList());

    }
}
