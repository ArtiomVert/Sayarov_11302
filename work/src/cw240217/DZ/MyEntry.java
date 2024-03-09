package cw240217.DZ;

import java.util.Map;

public class MyEntry<K, V> implements Map.Entry<K, V> {

    private K k;
    private V v;

    public MyEntry(K k, V v) {
        this.k = k;
        this.v = v;

    }

    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }

    @Override
    public V setValue(V value) {
        v = value;
        return v;
    }

    @Override
    public String toString() {
        return k.toString() + "=" + v.toString();
    }
}
