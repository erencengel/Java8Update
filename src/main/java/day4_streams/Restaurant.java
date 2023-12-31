package day4_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Restaurant {

    public static void main(String[] args) {

        List<Entree> menu = new ArrayList<>(Arrays.asList(
                new Entree("Starter Salad", 300, true),
                new Entree("Fish && Chips", 700, false),
                new Entree("Cheese Pizza", 600, true),
                new Entree("Lentil Soup", 200, true),
                new Entree("Chicken Soup", 300, false)
        ));

        System.out.println("--------------isVegetarian - count---------------");
        System.out.println(menu.stream()
                .filter(Entree::isVegetarian) // p -> p.isVegetarian
                .count());

        System.out.println("--------------isVegetarian - if there is any---------------");
        System.out.println("menu.stream().anyMatch(Entree::isVegetarian) = " + menu.stream().anyMatch(Entree::isVegetarian));

        System.out.println("--------------sort the entriees by calories (highest to lowest) and remove the biggest 2, what are the names of the remaining entress---------------");
        menu.stream()
                .sorted(Comparator.comparing(Entree::getCalories).reversed())
                .skip(2)
                .map(Entree::getName)
                .forEach(System.out::println);
    }

}
