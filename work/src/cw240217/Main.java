package cw240217;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MySet<String> set = new MySet<>();
        for (int i = -10; i < 10; i++){
            set.add(i+" ");
        }
        for (int i = -10; i < 10; i+=2){
            set.remove(i+" ");
        }
        for (String i: set.get()){
            System.out.print(i);
        }
//        List<Student> list = new ArrayList<>();
//        list.add(new Student(12, "q"));
//        list.add(new Student(15, "q"));
//        list.add(new Student(17, "q"));
//        list.add(new Student(13, "q"));
//        print(list);
    }
//    public static void print(List<? extends Person> list){
//        for(Person p:list){
//            System.out.println(p.age);
//        }
//    }
}