package cw240427;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ApplyDiscontTest {
    DiscountRepository dr;
    Bucket bucket;
    ApplyDiscont applyDiscont;
    Long userId = 1234L;

    @Before
    public void setUp() {
        dr = Mockito.mock(DiscountRepository.class);
        ArrayList<Purchase> ps = new ArrayList<>();
        for (int i = 100; i <= 1000; i += 100) {
            BigDecimal cost = new BigDecimal(i);
            ps.add(new Purchase(i, cost, cost));
        }
        bucket = new Bucket(ps);
        applyDiscont = new ApplyDiscont(dr);
    }

    @Test
    void test1() {
        Mockito.when(dr.getDiscountForUser(userId)).thenReturn(-100);
        Bucket b = applyDiscont.calculateDiscountForBucket(userId, bucket);
        for (Purchase p : b.getPurchases()) {
            assertEquals(p.getPrice(), p.getCost());
        }
    }

    @Test
    void test2() {
        Mockito.when(dr.getDiscountForUser(userId)).thenReturn(0);
        Bucket b = applyDiscont.calculateDiscountForBucket(userId, bucket);
        for (Purchase p : b.getPurchases()) {
            assertEquals(p.getPrice(), p.getCost());
        }
    }
    @Test
    void test3() {
        Mockito.when(dr.getDiscountForUser(userId)).thenReturn(33);
        Bucket b = applyDiscont.calculateDiscountForBucket(userId, bucket);
        for (Purchase p : b.getPurchases()) {
            BigDecimal disc = p.getPrice().multiply(new BigDecimal("0.33"));
            BigDecimal target = p.getPrice().subtract(disc);
            assertEquals(target, p.getCost());
        }
    }
    @Test
    void test4() {
        Mockito.when(dr.getDiscountForUser(userId)).thenReturn(100);
        Bucket b = applyDiscont.calculateDiscountForBucket(userId, bucket);
        for (Purchase p : b.getPurchases()) {
            assertEquals(new BigDecimal(0), p.getCost());
        }
    }
    @Test
    void test5() {
        Mockito.when(dr.getDiscountForUser(userId)).thenReturn(1000998);
        Bucket b = applyDiscont.calculateDiscountForBucket(userId, bucket);
        for (Purchase p : b.getPurchases()) {
            assertEquals(new BigDecimal(0), p.getCost());
        }
    }
}