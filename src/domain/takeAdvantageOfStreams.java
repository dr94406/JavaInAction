package domain;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static domain.Dish.Type.FISH;
import static domain.Dish.Type.MEAT;

public class takeAdvantageOfStreams {
    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, MEAT),
                new Dish("beef", false, 700, MEAT),
                new Dish("chicken", false, 400, MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, FISH),
                new Dish("salmon", false, 450, FISH));

//        List<Dish> vegetarianDishes = new ArrayList<>();
//        for (Dish dish : menu) {
//            if (dish.isVegetarian()) {
//                vegetarianDishes.add(dish);
//            }
//        }
//        System.out.println(vegetarianDishes);
//        System.out.println(menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList()));

//        List<Dish> filteredMenu
//                = menu.stream().filter(dish -> dish.getCalories() < 320)
//                .collect(Collectors.toList());
//        System.out.println(filteredMenu);
//
//        List<Dish> slicedMenu1 = menu.stream().takeWhile(dish -> dish.getCalories() > 320).collect(Collectors.toList());
//        System.out.println(slicedMenu1);

//        List<Dish> slicedMenu2 = menu.stream().dropWhile(dish -> dish.getCalories() < 320).collect(Collectors.toList());
//        System.out.println(slicedMenu2);
//
//        List<Dish> dishes = menu.stream().filter(dish -> dish.getCalories() > 320).limit(3).collect(Collectors.toList());
//        System.out.println(dishes);

//        List<Dish> dishes = menu.stream().filter(dd -> dd.getCalories() > 300)
//                .skip(2).collect(Collectors.toList());
//        List<Dish> skip2meat = menu.stream().filter(s -> s.getType().equals(MEAT)).limit(2).collect(Collectors.toList());
//        System.out.println(skip2meat);

//        List<Integer> dishNameLengths = menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
//        System.out.println(dishNameLengths);


        if(menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);

    }
}
