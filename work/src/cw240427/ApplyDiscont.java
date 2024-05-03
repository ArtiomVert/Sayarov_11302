package cw240427;

import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

public class ApplyDiscont implements BucketService {
    DiscountRepository dr;

    public ApplyDiscont(DiscountRepository dr) {
        this.dr = dr;
    }

    @Override
    public Bucket calculateDiscountForBucket(long userId, Bucket bucket) {
        List<Purchase> ps = bucket.getPurchases();
        for (Purchase p : ps) {
            BigDecimal cost = p.getCost();
            int discont = dr.getDiscountForUser(userId);
            if (discont<0){
                discont = 0;
            }
            if (discont>100){
                discont = 100;
            }
            BigDecimal disc = cost.multiply(new BigDecimal(discont).movePointLeft(2));
            cost = cost.subtract(disc);
            p.setCost(cost);
        }
        return new Bucket(ps);
    }
}
