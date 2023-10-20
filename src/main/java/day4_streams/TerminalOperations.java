package day4_streams;

import java.util.Arrays;

public class TerminalOperations {

    public static void main(String[] args) {
        String[] names = {"Val", "Betul", "Ercan", "Nihan", "Huong"};
        Arrays.stream(names)
                .filter(p -> p.contains("a"))
                .forEach(System.out::println);

        Arrays.stream(names)
                .filter(p -> p.contains("a"))
                .count(); // returns a long for the number of elements - it stops the stream

        System.out.println("------------mini task of unique characters-----------");
        //given a String count the number of unique character in the String
        String str = "aaaaaaaaabbbbbccccccddddeeeefffaaasssssiiii";
        System.out.println("str.chars().distinct().count() = " + str.chars().distinct().count());

        System.out.println("\t\t\tall Match");
        int[] nums = {4,5,15,20,19,7};
        System.out.println("Arrays.stream(nums).allMatch(p -> p < 30) = " + Arrays.stream(nums).allMatch(p -> p < 30));

        System.out.println("\t\t\tany Match");
        System.out.println("Arrays.stream(nums).anyMatch(p -> p % 50 == 0) = " + Arrays.stream(nums).anyMatch(p -> p % 50 == 0));

        System.out.println("\t\t\tnone Match");
        System.out.println("Arrays.stream(nums).noneMatch(p -> p % 50 == 0) = " + Arrays.stream(nums).noneMatch(p -> p % 50 == 0));


    }

}
