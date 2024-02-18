import java.util.ArrayList;
import java.util.List;

public class MySet<T> {
    List<T>[] set = new ArrayList[64];
    public void add(T a){
        int hc = Math.abs(a.hashCode())%64;
        if(set[hc] == null){
            set[hc] = new ArrayList<>();
            set[hc].add(a);
        } else{
            boolean flag = false;
            for (T i: set[hc]){
                flag = flag || i.equals(a);
            }
            if(!flag){
                set[hc].add(a);
            }
        }
    }
    public List<T> get(){
        List<T> out = new ArrayList<>();
        for (List<T> l: set){
            if (l==null){continue;}
            out.addAll(l);
        }
        return out;
    }

    public boolean contain(T a){
        int hc = Math.abs(a.hashCode())%64;
        if(set[hc] == null){
            return false;
        } else{
            boolean flag = false;
            for (T i: set[hc]){
                flag = flag || i.equals(a);
            }
            return flag;
        }
    }
    public void remove(T a){
        int hc = Math.abs(a.hashCode())%64;
        if(set[hc] != null) {
            set[hc].remove(a);
        }
    }
}
