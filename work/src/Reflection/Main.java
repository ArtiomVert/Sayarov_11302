package Reflection;

public class Main {
    public static void main(String[] args) throws Exception {
        Student s = new Student("VASA", "IVAN", 12);
        s.s = new Student(s.surname, s.name, s.age+1);
        System.out.println(ClassToJSON.toJSON(s));
    }
}

class Student {
    String name;
    String surname;
    int age;
    Integer age1;
    Student s = null;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        age1 = new Integer(age+1);
    }
}