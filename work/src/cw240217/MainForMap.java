package cw240217;

public class MainForMap {
    public static void main(String[] args) {
        MyMap<String, Integer> myMap = new MyMap<>();
        for (int i = 0; i < 100; i++) {
            myMap.push("i=" + i, i);
        }
        myMap.remove("i=56");
        for (int i = 0; i < 100; i++) {
            System.out.print(myMap.get("i="+i)+ " ");
        }
    }
}
