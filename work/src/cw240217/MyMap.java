package cw240217;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K, V> {
    ArrayList<Elem<K, V>>[] list = new ArrayList[64];

    public void push(K k, V v) {
        int hc = Math.abs(k.hashCode()) % 64;
        if (list[hc] == null) {
            list[hc] = new ArrayList<>();
            list[hc].add(new Elem<K, V>(k, v));
        } else {
            boolean flag = true;
            for (Elem<K, V> i : list[hc]) {
                if (i.k.equals(k)){
                    i.v = v;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list[hc].add(new Elem<K, V>(k, v));
            }
        }
    }

    public V get(K k) {
        int hc = Math.abs(k.hashCode()) % 64;
        if(list[hc] == null){
            return null;
        }
        for (Elem<K, V> e: list[hc]){
            if (e.k.equals(k)) {
                return e.v;
            }
        }
        return null;
    }

    public void remove(K k) {
        int hc = Math.abs(k.hashCode()) % 64;
        if (list[hc] != null) {
            for (Elem<K, V> e: list[hc]){
                if (e.k.equals(k)) {
                    list[hc].remove(e);
                    break;
                }
            }
        }
    }
}
