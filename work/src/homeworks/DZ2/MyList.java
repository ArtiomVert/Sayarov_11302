package homeworks.DZ2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<T> implements List<T> {
    private int cap = 10;
    private int size = 0;
    private T[] list = (T[]) new Object[cap];

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    private void more() {
        if ((double) cap / size > 0.7) {
            cap += 10;
            T[] lt = (T[]) new Object[cap];
            System.arraycopy(list, 0, lt, 0, size);
            list = lt;
        }
    }

    @Override
    public boolean add(T t) {
        list[size] = t;
        size++;
        more();
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return list[index];
    }

    @Override
    public boolean remove(Object o) {
        int index = 0;
        for (index = 0; index < size; index++) {
            if (list[index].equals(o)) {
                remove(index);
                return true;
            }
        }
        return false;
    }


    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        T[] lt = (T[]) new Object[cap];
        System.arraycopy(list, 0, lt, 0, index);
        for (int i = index + 1; i < size; i++) {
            lt[i - 1] = list[i];
        }
        T t = list[index];
        list = lt;
        size--;
        return t;
    }

    @Override
    public Object[] toArray() {
        T[] lt = (T[]) new Object[size];
        System.arraycopy(list, 0, lt, 0, size);
        return lt;
    }

    @Override
    public void clear() {
        cap = 10;
        size = 0;
        list = (T[]) new Object[cap];
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }


    @Override
    public T set(int index, T element) {
        return null;
    }


    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
