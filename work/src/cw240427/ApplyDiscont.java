package cw240427;

import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

public class ApplyDiscont implements BucketService{

    @Override
    public Bucket calculateDiscountForBucket(long userId, Bucket bucket) {
        List<Purchase> ps = bucket.getPurchases();
        DiscountRepository dr = new DataService();
        for(Purchase p:ps){
             BigDecimal cost = p.getCost();
             BigDecimal disc = cost.multiply(new BigDecimal(dr.getDiscountForUser(userId)).movePointLeft(2));
             cost = cost.subtract(disc);
             p.setCost(cost);
        }
        return new Bucket(ps);
    }
}
