package homeworks.DZ2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MainWithStudent {
//    16. Вывести имя и фамилию студента, чей балл больше или равен 56
//    17. Вывести средний балл студентов, чей балл больше или равен 56
//    18. Вывести самую длинную фамилию среди студентов, чей балл больше или равен 56

    public static String task16(Student[] st) {
        Student s = Arrays.stream(st)
                .filter(q -> q.mark >= 56)
                .findFirst()
                .orElse(null);
        if (s != null) return s.name + " " + s.surname;
        return null;
    }

    public static double task17(Student[] st) {
        double d = Arrays.stream(st)
                .filter((Student q) -> q.mark >= 56)
                .flatMapToInt(q -> IntStream.of(q.mark))
                .average()
                .orElse(0);
        return d;
    }

    public static String task18(Student[] st) {
        Student s = Arrays.stream(st)
                .filter((Student q) -> q.mark >= 56)
                .max((s1, s2) -> {
                    if (s1.surname.length() > s2.surname.length()) return 1;
                    if (s1.surname.length() < s2.surname.length()) return -1;
                    return 0;
                })
                .orElse(null);
        if (s != null) return s.surname;
        return null;
    }

    public static void main(String[] args) {
        Student[] st = new Student[]{
                new Student("Ivan", "Ivanov", 43),
                new Student("Petr", "Konovalov", 67),
                new Student("Nikolay", "Pirogov", 32),
                new Student("Nikita", "Medvedev", 57),
                new Student("Boris", "Orlov", 80),
                new Student("Timur", "Tichomirov", 60),
                new Student("Vladimir", "Popov", 70)
        };
        System.out.println(task16(st));
        System.out.println(task17(st));
        System.out.println(task18(st));
    }
}
