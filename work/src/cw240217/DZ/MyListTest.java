package cw240217.DZ;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    static MyList<Integer> list;

    @BeforeAll
    static void prepare(){
        list = new MyList<>();
        for (int i = 0; i < 40; i++) {
            list.add(i);
        }
    }
    @Test
    void contains() {
        assertTrue(list.contains(3));
        assertFalse(list.contains(99));
    }

    @Test
    void add() {
        list.add(999999);
        assertTrue(list.contains(999999));
    }

    @Test
    void get() {
        assertNotEquals(1, list.get(0));
        assertEquals(list.get(5), 5);
    }

    @Test
    void remove() {
        list.remove(7);
        assertFalse(list.contains(7));
    }
}