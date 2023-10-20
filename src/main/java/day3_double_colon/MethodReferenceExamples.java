package day3_double_colon;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExamples {

    public static void main(String[] args) {

        //CONSUMER
        Consumer<Integer> print = n -> System.out.println(n);
        print.accept(10);

        Consumer<Integer> print2 = System.out::println;
        print2.accept(5);

        //FUNCTION
        Function<String,String> toLower = s -> s.toLowerCase();
        System.out.println("toLower.apply(\"JAVA\") = " + toLower.apply("JAVA"));

        Function<String,String> toLower2 = String::toLowerCase;
        System.out.println("toLower2.apply(\"HELLO\") = " + toLower2.apply("HELLO"));

        //SUPPLIER
        Supplier<Double> randomNum = () -> Math.random();
        System.out.println("randomNum.get() = " + randomNum.get());

        Supplier<Double> randomNum2 = Math::random;
        System.out.println("randomNum2.get() = " + randomNum2.get());

        //BIFUNCTION
        BiFunction<String, Integer, String> sub = (str, i) -> str.substring(i);
        System.out.println("sub.apply(\"friday\", 3) = " + sub.apply("friday", 3));

        BiFunction<String, Integer, String> sub2 = String::substring;
        System.out.println("sub2.apply(\"sunday\", 4) = " + sub2.apply("sunday", 4));


    }

}
