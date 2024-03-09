package cw240217.DZ;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {

    @Test
    void test1() {
        Map<Integer, String> m1 = new MyMap<>();
        m1.put(1, "A");
        m1.put(2, "B");
        Map<Integer, String> m2 = new MyMap<>();
        m2.put(3, "C");
        m2.put(4, "D");
        m1.putAll(m2);
        m1.remove(4);
        Map<Integer, String> m3 = new HashMap<>();
        m3.put(1, "A");
        m3.put(2, "B");
        m3.put(3, "C");
        assertEquals(m1.keySet(), m3.keySet());
        assertEquals(m1.entrySet(), m3.entrySet());
        assertTrue(m1.containsKey(2));
        assertFalse(m1.containsKey(4));
        assertTrue(m1.containsValue("A"));
        assertFalse(m1.containsValue("D"));
    }


}