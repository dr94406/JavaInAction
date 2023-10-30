package domain;

import java.util.Arrays;
import java.util.List;

import static domain.Dish.Type.*;
import static java.util.stream.Collectors.toList;

public class StreamSlicing {
    public static void main(String[] args) {

    List<Dish> specialMenu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, OTHER),
            new Dish("prawns", false, 300, FISH),
            new Dish("rice", true, 350, OTHER),
            new Dish("chicken", false, 400, MEAT),
            new Dish("french fries", true, 530, OTHER));

    /** filter 이용하는 방법 **/

        List<Dish> filteredMenu = specialMenu.stream()
            .filter(dish -> dish.getCalories() < 320)
            .collect(toList());

    /** takeWhile 이용하는 방법 **/
    List<Dish> slicedMenu = specialMenu.stream()
            .takeWhile(dish -> dish.getCalories() < 320)
            .collect(toList());

    /** dropWhile 이용하는 방법 **/
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
    /** limit **/
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList());

    /** skip **/
        List<Dish> SkipMenu = specialMenu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
    }
}
