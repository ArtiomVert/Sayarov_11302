package cw240302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        long[] l = new long[]{665L * Integer.MAX_VALUE+532353, 623L * Integer.MIN_VALUE+73286, 0};
        List<Integer> i = new ArrayList<>();
        for (long q:l){
            if (q>Integer.MAX_VALUE || q<Integer.MIN_VALUE){
                i.add((int) (q>>32));
            }
            i.add((int) q);
        }
        System.out.println(Arrays.toString(i.toArray()));
        List<Integer> t = Arrays.stream(l)
                .map((long e) -> e / 3)
                .filter((long e) -> ((e & 1) == 0))
                .mapToObj((long e) -> {
                    List<Integer> vals = new ArrayList<>();
                    if (e > Integer.MAX_VALUE || e < Integer.MIN_VALUE) {
                        vals.add((int) (e >> 32));
                    }
                    vals.add((int) e);
                    return vals;
                })
                .flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(t.toString());
    }

}
