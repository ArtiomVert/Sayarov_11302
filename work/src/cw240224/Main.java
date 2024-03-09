package cw240224;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Integer[] l = new Integer[]{2, 3, 7, 4, 9, 4, 2, 1};
        Arrays.sort(l, new IntComparator());
        System.out.println(Arrays.toString(l));
        IntStream.range(1, 10).forEach((int a)->{
            a+=2;
            System.out.println(a);
        });
        IntStream.range(1, 11).filter((int a)-> a%2==1).forEach(System.out::print);

        int[] array = IntStream.range(1, 11).toArray();
        array = Arrays.stream(array).filter((int a)-> (a&1)==0).toArray();
        System.out.println(Arrays.toString(array));
    }
}
