package cw240427;

import org.mockito.Mockito;

public class DataService implements DiscountRepository{
    @Override
    public int getDiscountForUser(Long userId) {
        DiscountRepository dr = Mockito.mock(DiscountRepository.class);
        Mockito.when(dr.getDiscountForUser(userId)).thenReturn(33);
        return dr.getDiscountForUser(userId);
    }
}
