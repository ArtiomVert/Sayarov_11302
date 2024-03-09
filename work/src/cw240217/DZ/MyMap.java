package cw240217.DZ;

import java.util.*;

public class MyMap<K, V> implements Map<K, V> {
    private int size = 0;
    ArrayList<Entry<K, V>>[] list = new ArrayList[64];

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object k) {
        int hc = Math.abs(k.hashCode()) % 64;
        if (list[hc] == null) {
            return false;
        }
        for (Entry<K, V> e : list[hc]) {
            if (e.getKey().equals(k)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object v) {
        for (ArrayList<Entry<K, V>> a : list) {
            if (a == null) continue;
            for (Entry<K, V> e : a) {
                if (e.getValue().equals(v)) return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object k) {
        int hc = Math.abs(k.hashCode()) % 64;
        if (list[hc] == null) {
            return null;
        }
        for (Entry<K, V> e : list[hc]) {
            if (e.getKey().equals(k)) {
                return e.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K k, V v) {
        int hc = Math.abs(k.hashCode()) % 64;
        if (list[hc] == null) {
            list[hc] = new ArrayList<>();
            list[hc].add(new MyEntry<K, V>(k, v));
            size++;
        } else {
            boolean flag = true;
            for (Entry<K, V> i : list[hc]) {
                if (i.getKey().equals(k)) {
                    i.setValue(v);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list[hc].add(new MyEntry<K, V>(k, v));
                size++;
            }
        }
        return v;
    }

    @Override
    public V remove(Object k) {
        V v = null;
        int hc = Math.abs(k.hashCode()) % 64;
        if (list[hc] != null) {
            for (Entry<K, V> e : list[hc]) {
                if (e.getKey().equals(k)) {
                    v = e.getValue();
                    list[hc].remove(e);
                    size--;
                    break;
                }
            }
        }
        return v;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Set<? extends K> keys = m.keySet();
        for (K k : keys) {
            put(k, m.get(k));
        }
    }

    @Override
    public void clear() {
        size = 0;
        list = new ArrayList[64];
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (ArrayList<Entry<K, V>> a : list) {
            if (a == null) continue;
            for (Entry<K, V> e : a) {
                keys.add(e.getKey());
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();
        for (ArrayList<Entry<K, V>> a : list) {
            if (a == null) continue;
            for (Entry<K, V> e : a) {
                values.add(e.getValue());
            }
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        HashMap<K, V> es = new HashMap<>();
        for (ArrayList<Entry<K, V>> a : list) {
            if (a == null) continue;
            for (Entry<K, V> e: a){
                es.put(e.getKey(), e.getValue());
            }
        }
        return es.entrySet();
    }


}
