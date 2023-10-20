package day2_functional_interface.appleeren;

import java.util.ArrayList;
import java.util.List;

public class AppleRunner {

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple("green", 350));
        list.add(new Apple("green", 150));
        list.add(new Apple("blue", 100));
        list.add(new Apple("orange", 500));

        System.out.println(appleMethod(list, new AppleHeavyPredicate()));
        System.out.println(appleMethod(list, new AppleGreenColorPredicate()));
    }

    public static List<Apple> appleMethod(List<Apple> apple, ApplePredicate applePredicate){
        List<Apple> list = new ArrayList<>();
        for(Apple apple1: apple){
            if(applePredicate.test(apple1)){
                list.add(apple1);
            }
        }
        return list;
    }
}
