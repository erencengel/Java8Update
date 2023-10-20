package day2_functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleRunner {

    public static void main(String[] args) {

        List<Apple> data = new ArrayList<>(Arrays.asList(
                new Apple("Red", 30),
                new Apple("Red", 50),
                new Apple("Green", 55),
                new Apple("Green", 100),
                new Apple("Yellow", 40),
                new Apple("Yellow", 70),
                new Apple("Green", 58),
                new Apple("Red", 65)
        ));

        List<Apple> greenApples = filter(data, new AppleGreenColorPredicate());
        System.out.println("greenApples = " + greenApples);

        //() -> {}
        //one parameter --> no need to parenthesis
        //one line code --> no need to curly braces
        //no need put there return keyword
        //no need to put object type that is "Apple"
        //GREAT :)
        List<Apple> smallApples = filter(data, apple -> apple.getWeight() < 50);
        System.out.println("smallApples = " + smallApples);


    }

    public static List<Apple> filter(List<Apple> apples, ApplePredicate applePredicate){
        List<Apple> filteredApples = new ArrayList<>();
        for(Apple each: apples){
            if(applePredicate.test(each)){
                filteredApples.add(each);
            }
        }
        return filteredApples;
    }

}
