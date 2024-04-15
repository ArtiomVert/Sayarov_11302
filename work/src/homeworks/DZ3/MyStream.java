package homeworks.DZ3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        for (T t : list) {
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

    public <R> MyStream<R> flatMap(OperFlat<T, MyStream<R>> oper) {
        List<R> lt = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            MyStream<? extends R> ms = oper.oper(list[i]);
            lt.addAll(Arrays.asList(ms.list));
        }
        return new MyStream<>((R[]) lt.toArray());
    }

    public T findAny(OperFind<T> oper) {
        for (T t : list) {
            if (oper.oper(t)) {
                return t;
            }
        }
        throw new RuntimeException("Can't find any");
    }

    public int count(OperFind<T> oper) {
        int c = 0;
        for (T t : list) {
            if (oper.oper(t)) {
                c++;
            }
        }
        return c;
    }

    public IntStream flatMapToInt(OperFlat<T, IntStream> oper) {
        List<Integer> lt = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            oper.oper(list[i]).forEach(in -> lt.add(in));
        }
        return Arrays.stream(lt.toArray()).flatMapToInt(i -> IntStream.of((Integer) i));
    }

    public T max(OperMax<T> oper) {
        T cur = list[0];
        for (T t : list) {
            if (oper.oper(t, cur) > 0) {
                cur = t;
            }
        }
        return cur;
    }
}
