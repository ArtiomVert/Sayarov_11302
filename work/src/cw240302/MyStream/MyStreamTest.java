package cw240302.MyStream;


import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
class MyStreamTest {

    @Test
    void map() {
        Integer[] i = new Integer[]{1, 2, 3, 4, 5, 6};
        MyStream<Integer> t = new MyStream<Integer>(i).map((Integer q)->q*10);
        System.out.println(Arrays.toString(t.list));
        assertEquals(Arrays.toString(t.list), "[10, 20, 30, 40, 50, 60]");
    }
}