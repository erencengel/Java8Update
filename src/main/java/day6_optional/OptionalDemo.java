package day6_optional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class OptionalDemo {

    public static void main(String[] args) {

        //the point of Optional is to get rid of NULLPOINTEREXCEPTION (null problem of Java)

        System.out.println("---------- empty Optional ---------");
        Optional<String> empty = Optional.empty(); //this method uses/creates an empty optional object - it is still an object
        System.out.println(empty);

        Optional<String> empty2 = null; // there is no object here
        System.out.println(empty2);

        //System.out.println(empty.get()); // NoSuchElementException
        //System.out.println(empty2.get()); // NullPointerException

        System.out.println("---------- isPresent ---------");
        System.out.println(empty.isPresent()); // there is an object but no value --> false (but no exception)
        //System.out.println(empty2.isPresent()); --> NullPointerException
        System.out.println(Optional.of("java").isPresent()); // --> true
        System.out.println(Optional.ofNullable(empty2).isPresent()); // --> no exception but FALSE

        System.out.println("---------- findAny ---------");
        List<Integer> nums = List.of(3,5,1,5,10,284,23,28,48);
        Optional<Integer> lessThan300 = nums.stream()
                .filter(p -> p < 300)
                .findAny();
        System.out.println(lessThan300);
        System.out.println(lessThan300.get());

        System.out.println("---------- findAny opposite---------");
        Optional<Integer> moreThan300 = nums.stream()
                .filter(p -> p > 300)
                .findAny();
        System.out.println(moreThan300);
        //System.out.println(moreThan300.get()); --> can not get anything from empty

        System.out.println("---------- ifPresent ---------");
        Optional<Integer> moreThan300Again = nums.stream()
                .filter(p -> p > 250) // to check invalid you can use 300 instead
                .findAny();
        moreThan300Again.ifPresent(System.out::println);

        System.out.println("---------- orElse ---------");
        Optional<Integer> moreThan3 = nums.stream()
                .filter(p -> p > 300)
                .findAny();
        System.out.println(moreThan3.orElse(-1));

        System.out.println("---------- min ---------");
        List<Double> temperatures = List.of(60.5, 72.1, 65.2, 67.8, 68.3);
        OptionalDouble tempsMin = temperatures.stream()
                .mapToDouble(n -> n)
                .min();
        System.out.println(tempsMin); //this is the optional object
        System.out.println(tempsMin.getAsDouble()); //this is a double type

        System.out.println("---------- max ---------");
        OptionalDouble tempsMax = temperatures.stream()
                .mapToDouble(n -> n)
                        .max();
        System.out.println(tempsMax); //this is the optional object
        System.out.println(tempsMax.getAsDouble()); //this is a double type

        System.out.println("---------- average ---------");
        OptionalDouble tempsAvg = temperatures.stream()
                .mapToDouble(n -> n)
                .average();
        System.out.println(tempsAvg); //this is the optional object
        System.out.println(tempsAvg.getAsDouble()); //this is a double type

        System.out.println("---------- reduce ---------");
        Optional<Double> minReduced = temperatures.stream().reduce(Double::min);
        System.out.println(minReduced);
        System.out.println(minReduced.get());
        Optional<Double> maxReduced = temperatures.stream().reduce(Double::max);
        System.out.println(maxReduced);
        System.out.println(maxReduced.get());
        Optional<Double> sumReduced = temperatures.stream().reduce(Double::sum);
        System.out.println(sumReduced);
        System.out.println(sumReduced.get());
    }
}
