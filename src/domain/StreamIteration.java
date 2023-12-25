package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static domain.Dish.Type.FISH;
import static domain.Dish.Type.MEAT;

public class StreamIteration {
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

        // 1 외부반복 -> forEash문
//        List<String> names = new ArrayList<>();
//        for (Dish dish : menu) {
//            names.add(dish.getName());
//        }
//        System.out.println(names);

        // 2 컬렉션: 내부적으로 숨겼던 반복자 사용한 외부반복
//        List<String> names = new ArrayList<>();
//
//        Iterator<Dish> iterator = menu.iterator();
//        while(iterator.hasNext()) {
//            Dish dish = iterator.next();
//            names.add(dish.getName());
//        }
//        System.out.println(names);

//        // 3 스트림 내부반복
//          List<String> names = menu.stream().map(Dish::getName).collect(Collectors.toList());
//          System.out.println(names);

        // 4. quiz
//        List<String> highCaloricDishes = new ArrayList<>();
//        Iterator<Dish> iterator = menu.iterator();
//        while (iterator.hasNext()) {
//            Dish dish = iterator.next();
//            if(dish.getCalories() > 300) {
//                highCaloricDishes.add(dish.getName());
//            }
//        }
//        System.out.println(highCaloricDishes);
        List<String> highCaloricDishes = menu.stream().filter(s -> s.getCalories() > 300).map(Dish::getName).collect(Collectors.toList());
        System.out.println(highCaloricDishes);


    }
}
