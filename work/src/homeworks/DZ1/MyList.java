package homeworks.DZ1;

public class MyList {
    private int size = 0;
    private Node head = null;
    private Node end = null;

    public int length(){
        return size;
    }

    public MyList() {}

    public MyList(int[] ints) {
        this(ints, false);
    }

    public MyList(int[] ints, boolean sort) {
        if (sort) {
            setSortedMyList(ints);
        } else {
            size = ints.length;
            head = new Node(ints[0]);
            Node curNode = head;
            for (int i = 1; i < size; i++) {
                curNode.next = new Node(ints[i]);
                curNode = curNode.next;
            }
            end = curNode;
        }
    }

    public void add(int data) {
        if (size == 0) {
            head = new Node(data);
            end = head;
        } else {
            end.next = new Node(data);
            end = end.next;
        }
        size++;
    }

    public void add(int data, int index){
        Node newNode = new Node(data);
        if (index<0){
            return;
        }
        if (size == 0) {
            add(data);
            return;
        }
        if (index == size){
            add(data);
            return;
        }
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        Node curNode = head;
        for (int i = 1; i < index; i++) {
            curNode = curNode.next;
        }
        newNode.next = curNode.next;
        curNode.next = newNode;
        size++;
    }

    public void remove(int index){
        if (index<0){
            return;
        }
        if (index == 0){
            head = head.next;
        } else {
            Node curNode = head;
            for (int i = 1; i < index; i++){
                curNode = curNode.next;
            }
            curNode.next = curNode.next.next;
        }
        size--;
    }

    public int[] getAll() {
        int[] out = new int[size];
        Node curNode = head;
        for (int i = 0; i < size; i++) {
            out[i] = curNode.data;
            curNode = curNode.next;
        }
        return out;
    }

    public int getMax() {
        int max = head.data;
        Node curNode = head.next;
        for (int i = 1; i < size; i++) {
            if (curNode.data > max) {
                max = curNode.data;
            }
            curNode = curNode.next;
        }
        return max;
    }

    public int getIndex(int data){
        Node curNode = head;
        for (int i = 0; i < size; i++){
            if(curNode.data == data){
                return i;
            }
            curNode = curNode.next;
        }
        return -1;
    }

    public boolean have(int x) {
        Node curNode = head;
        for (int i = 0; i < size; i++) {
            if (curNode.data == x) {
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    public int count(int data){
        int c = 0;
        Node curNode = head;
        for (int i = 0; i < size; i++){
            if(curNode.data == data){
                c++;
            }
            curNode = curNode.next;
        }
        return c;
    }

    public void sort() {
        setSortedMyList(getAll());
    }

    private void setSortedMyList(int[] ints) {
        size = ints.length;
        head = new Node(ints[0]);
        end = head;
        for (int i = 1; i < size; i++) {
            Node newNode = new Node(ints[i]);
            if (newNode.data >= end.data) {
                end.next = newNode;
                end = end.next;
                continue;
            }
            if (newNode.data <= head.data) {
                newNode.next = head;
                head = newNode;
                continue;
            }
            Node curNode = head;
            while (curNode.next.data < newNode.data) {
                curNode = curNode.next;
            }
            newNode.next = curNode.next;
            curNode.next = newNode;
        }
    }
}
