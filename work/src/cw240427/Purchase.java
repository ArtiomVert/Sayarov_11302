package cw240427;

import java.math.BigDecimal;

public class Purchase {
    private long goodId;
    private BigDecimal price;
    private BigDecimal cost;

    public Purchase(long goodId, BigDecimal price, BigDecimal cost) {
        this.goodId = goodId;
        this.price = price;
        this.cost = cost;
    }

    public long getGoodId() {
        return goodId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
