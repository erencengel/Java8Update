package day5_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args) {

        System.out.println("------------Array------------");
        int[][] nums = {
                {1,2,3},
                {4,5,6},
                {7,8,9,10}
        };
        Stream<int[]> a = Arrays.stream(nums);

        Arrays.stream(nums)
                .map(Arrays::stream)
                .forEach(System.out::println);

        int[] combined = Arrays.stream(nums)
                .flatMapToInt(Arrays::stream)
                .toArray();
        System.out.println(Arrays.toString(combined));

        System.out.println("------------ArrayList------------");
        List<List<String>> namesList = new ArrayList<>(Arrays
                .asList(Arrays.asList("James", "Anna"), Arrays.asList("Emre", "Kelly"), Arrays.asList("Oleg", "Olly")
                ));
        List<String> allNames = namesList.stream() //Stream<List<String>>
                .flatMap(List::stream) // Stream<Stream>
                .collect(Collectors.toList());
        System.out.println(allNames);

        List<String> allNames2 = namesList.stream() //Stream<List<String>>
                .flatMap(List::stream)// Stream<Stream>
                .map(str -> str + str.length())
                .collect(Collectors.toList());
        System.out.println(allNames);
    }

}
