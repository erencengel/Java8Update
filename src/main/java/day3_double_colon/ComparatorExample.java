package day3_double_colon;

import java.util.*;

public class ComparatorExample {

    public static void main(String[] args) {
        System.out.println("--------------default---------------");
        List<Integer> nums = new ArrayList<>(Arrays.asList(4,2,1,6,21,5,2,10,14));
        nums.forEach(System.out::println);

        System.out.println("--------------sort in ascending order---------------");
        Collections.sort(nums);
        nums.forEach(System.out::println);

        System.out.println("--------------sort in descending order---------------");
        Collections.sort(nums, (n1, n2) -> n1 > n2 ? -1 : n1 < n2 ? 1 : 0);
        nums.forEach(System.out::println);

        System.out.println("--------------let's mix the numbers---------------");
        Collections.shuffle(nums);
        nums.forEach(System.out::println);

        System.out.println("--------------sort in ascending order---------------");
        Collections.sort(nums, (n1,n2) -> n1.compareTo(n2));
        //nums.sort((n1,n2) -> n1.compareTo(n2)); same with above
        nums.forEach(System.out::println);

        System.out.println("--------------sort in descending order---------------");
        Collections.sort(nums, (n1,n2) -> n2.compareTo(n1));
        //nums.sort((n1,n2) -> n2.compareTo(n1)); same with the above
        nums.forEach(System.out::println);

        System.out.println("--------------best way for descending---------------");
        Collections.shuffle(nums);
        nums.sort(Comparator.reverseOrder());
        nums.forEach(System.out::println);

        //summary: to sort in ascending order we just use sort(), and to sort in descending we can call the reverseOrder() method from comparator
        //also we have naturalOrder() method, opposite of reverseOrder()

    }

}
