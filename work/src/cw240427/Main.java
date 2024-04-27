package cw240427;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Purchase> ps = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            BigDecimal cost = new BigDecimal(r.nextInt(1000));
            ps.add(new Purchase(i, cost, cost));
        }
        Bucket b = new ApplyDiscont().calculateDiscountForBucket(r.nextLong(), new Bucket(ps));
        for(Purchase p: b.getPurchases()){
            System.out.println(p.getPrice()+" - " + p.getCost());
        }
    }
}
