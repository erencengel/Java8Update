package day5_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertTypes {

    public static void main(String[] args) {
        //convert from int[] to List<Integer>
        int[] nums = {3,4,5,2,6,1};
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList()); //boxed() method converts the IntStream to a Stream<Integer>

        //convert List<Integer> to int[]
        List<Integer> listNums = List.of(3,4,32,5,1,23,123,3);
        Object[] objects = listNums.stream().toArray(); // Object type cause restrictions to use some methods, not recommended
        int[] arr2 = listNums.stream().mapToInt(n -> n).toArray();


    }

}
