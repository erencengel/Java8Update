package day2_functional_interface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;

public class FunctionalInterfaceExamples {

    public static void main(String[] args) {

        System.out.println("--------Predicate--------");
        // Predicate<T>
        // boolean test(T t)
        Predicate<Integer> lessThan10 = n -> n < 10;
        System.out.println("lessThan10.test(5) = " + lessThan10.test(5));
        System.out.println("lessThan10.test(15) = " + lessThan10.test(15));
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,3,5,7,9,100));
        //remove all the odd numbers
        //removeIf() method uses Predicate functional interface
        nums.removeIf(n -> n%2 ==1);
        System.out.println("nums = " + nums);
        //palindrome
        Predicate<String> isPalindrome = s -> new StringBuilder(s).reverse().toString().equals(s);
        System.out.println("isPalindrome.test(\"racecar\") = " + isPalindrome.test("racecar"));
        System.out.println("isPalindrome.test(\"hello\") = " + isPalindrome.test("hello"));


        System.out.println("--------Consumer--------");
        // Consumer<T>
        // void accept(T t)
        // print the first character of the String
        Consumer<String> firstChar = n -> System.out.println(n.charAt(0));
        firstChar.accept("alperen");
        firstChar.accept("aslıhan");

        //forEach() method uses Consumer functional interface
        List<String> names = new ArrayList<>(Arrays.asList("Kelly", "James", "Eren", "Huong", "Oleg", "Salma"));
        names.forEach(n -> System.out.print(n + " "));
        names.forEach(n -> System.out.println(n.charAt(0) + " " + n.charAt(n.length()-1)));

        System.out.println("--------BiConsumer--------");
        // Biconsumer<T, V>
        // void accept(T t, V v)
        BiConsumer<Integer, Integer> sum = (n1,n2) -> System.out.println(n1 + n2);
        sum.accept(1,5);
        BiConsumer<List<String>, Integer> subNames = (namesList, end) -> {
          for(String each: namesList){
              System.out.println(each.substring(0,end));
          }
        };
        subNames.accept(names,3);

        Map<String, String> holidays = new HashMap<>();
        holidays.put("July","4th of July");
        holidays.put("December","Christmas");
        holidays.put("October","Hallowen");
        holidays.forEach((k,v) -> System.out.println(k + " " + v));

        System.out.println("--------Function--------");
        // Function<T,R>
        // R apply(T t)
        Function<String, Integer> countVowels = str -> {
            String vowels = "aeiou";
            int numOfVowels = 0;
            for(char each: str.toCharArray()){
                if(vowels.contains(each + "")) numOfVowels++;
            }
            return numOfVowels;
        };
        System.out.println(countVowels.apply("wooden spoon"));

        //convert int[] to a list
        Function<int[], List<Integer>> convertToList = arr -> {
            List<Integer> list = new ArrayList<>();
            for(int each: arr){
                list.add(each);
            }
            return list;
        };
        int[] a = {4,2,4,1,5,2};
        List<Integer> aList = convertToList.apply(a);
        System.out.println("aList = " + aList);

        System.out.println("--------Supplier--------");
        // Supplier<T>
        // T get()
        Supplier<String> getDay = () -> LocalDate.now().getDayOfWeek().name();
        System.out.println("getDay.get() = " + getDay.get());

        Supplier<Integer> getRandomNumber = () -> new Random().nextInt(1001);
        System.out.println("getRandomNumber.get() = " + getRandomNumber.get());

        Supplier<String> getDateTime = () -> LocalDateTime.now().format(DateTimeFormatter.ofPattern("M/d/y h:m a"));
        System.out.println("getDateTime.get() = " + getDateTime.get());
    }

}
