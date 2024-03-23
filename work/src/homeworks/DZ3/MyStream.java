package homeworks.DZ3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStream<T> {
    T[] list;

    public MyStream(T[] l) {
        list = Arrays.copyOf(l, l.length);
    }

    public MyStream<T> map(Operator<T> o) {
        for (int i = 0; i < list.length; i++) {
            list[i] = o.oper(list[i]);
        }
        return this;
    }

    public MyStream<T> filter(OperFilter<T> f) {
        List<T> lt = new ArrayList<>();
        for (T t : lt) {
            if (f.filter(t)) {
                lt.add(t);
            }
        }
        list = (T[]) lt.toArray();
        return this;
    }

    public MyStream<T> peek(OperPeek<T> oper) {
        forEach(oper);
        return this;
    }

    public void forEach(OperPeek<T> oper) {
        for (int i = 0; i < list.length; i++) {
            oper.peek(list[i]);
        }
    }

    public <R> MyStream<R> flatMap(OperFlat<T, R> o) {
        R[] lt = (R[]) new Object[list.length];
        for (int i = 0; i < list.length; i++) {
            lt[i] = o.oper(list[i]);
        }
        return new MyStream<>(lt);
    }
}
