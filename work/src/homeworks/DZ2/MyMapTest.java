package homeworks.DZ2;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {

    static MyMap<String, Integer> mm;

    @BeforeAll
    static void before() {
        mm = new MyMap();
    }

    @Test
    void testPut() {
        assertEquals(mm.put("q", 135), 135);
    }

    @Test
    void testGet() {
        mm.put("qq", 123);
        assertEquals(mm.get("qq"), 123);
    }

    @Test
    void testContainsKeyTrue() {
        mm.put("123", 123);
        assertTrue(mm.containsKey("123"));
    }

    @Test
    void testContainsKeyFalse() {
        assertFalse(mm.containsKey("123"));
    }

    @Test
    void testContainsValueTrue() {
        mm.put("123", 123);
        assertTrue(mm.containsValue(123));
    }

    @Test
    void testContainsValueFalse() {
        assertFalse(mm.containsValue(100));
    }

    @Test
    void testRemove() {
        mm.put("123", 123);
        assertEquals(mm.remove("123"), 123);
    }
}