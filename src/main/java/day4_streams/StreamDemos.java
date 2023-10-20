package day4_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamDemos {

    public static void main(String[] args) {

        //intermediate operations --> returns stream..filter, distinct...
        //terminal operations --> forEach()

        System.out.println("-------------Stream source-------------");
        int[] arr = {3,1,5,2,5,2,1,5};
        System.out.println(Arrays.stream(arr)); // we created a Stream, from the array, only printing so far

        List<Integer> list = new ArrayList<>(Arrays.asList(3,5,1,5,12,5,12,5));
        System.out.println(list.stream()); //we created a stream from a list, only printing so far

        System.out.println("-------------Intermediate Operations-------------");
        System.out.println("-------------distinct-------------");
        System.out.println(list.stream().distinct()); //this still returns a stream
        list.stream().distinct().forEach(System.out::println); // .forEach(n -> System.out.println(n));

        System.out.println("-------------filter-------------");
        list.stream()
                .filter(p -> p % 2 == 0)
                .forEach(System.out::println);

        System.out.println("-------------filter with distinct-------------");
        list.stream()
                .distinct()
                .filter(p -> p % 2 == 0)
                .forEach(System.out::println);

        System.out.println("-------------limit-------------");
        list.stream()
                .limit(5)
                .forEach(System.out::println);

        System.out.println("-------------limit - get the first 6 numbers that are less than 4-------------");
        list.stream()
                .filter(p -> p < 4)
                .limit(6)
                .forEach(System.out::println);

        System.out.println("-------------skip-------------");
        list.stream()
                .skip(5)
                .forEach(System.out::println);

        System.out.println("-------------skip && limit-------------");
        list.stream()
                .skip(4)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("-------------map-------------");
        list.stream()
                .map(n -> n*2)
                .forEach(System.out::println);

        System.out.println("-------------map-2-------------");
        list.stream()
                .limit(6)
                .map(n -> n*n)
                .forEach(System.out::println);

        System.out.println("-------------sorted-------------");
        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("-------------sorted-2-------------");
        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
