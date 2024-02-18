import java.util.ArrayList;
import java.util.List;

public class MyMap<K, V> {
    List<Elem> list = new ArrayList<>();
    List<K> keys = new ArrayList<>();

    public void put(K k, V v){
        if (keys.contains(k)){
            for (Elem e: list){
                if(e.k.equals(k)){
                    e.v = v;
                }
            }
        } else {
            list.add(new Elem(k, v));
            keys.add(k);
        }
    }
    public void remove(K k){
        if(keys.contains(k)){
            Elem de = null;
            for (Elem e: list){
                if(e.k.equals(k)){
                    de = e;
                }
            }
            list.remove(de);
        }
    }
}
