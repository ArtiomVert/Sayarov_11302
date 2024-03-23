package ControlWork1Var2;

public class MyList {
    private int cap = 3;
    private int size = 0;
    private String[] list = new String[cap];

    public int size() {
        return size;
    }

    private void more() {
        if ((double) cap / size > 0.6) {
            cap += 2;
            String[] lt = new String[cap];
            System.arraycopy(list, 0, lt, 0, size);
            list = lt;
        }
    }

    public void add(String t) {
        list[size] = t;
        size++;
        more();
    }

    public String get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return list[index];
    }

    public String[] toArray() {
        String[] lt = new String[size];
        System.arraycopy(list, 0, lt, 0, size);
        return lt;
    }
}
