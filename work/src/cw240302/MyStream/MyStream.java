package cw240302.MyStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStream<T> {
    T[] list;
    public MyStream(T[] l){
        list = Arrays.copyOf(l, l.length);
    }
    public MyStream<T> map(Operator<T> o){
        for (int i = 0; i < list.length; i++) {
            list[i] = o.oper(list[i]);
        }
        return this;
    }
    public MyStream<T> filter(OperFilter<T> f){
        List<T> lt = new ArrayList<>();
        for (T t: lt){
            if (f.filter(t)){
                lt.add(t);
            }
        }
        list = (T[]) lt.toArray();
        return this;
    }
    public void peek(OperPeek<T> oper){
        for (int i = 0; i < list.length; i++) {
            oper.peek(list[i]);
        }
    }
}
