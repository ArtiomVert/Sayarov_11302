package ControlWork2Var2;

import java.util.stream.IntStream;

public class Task2 {
    public static void main(String[] args) {
        double smoke_women = Reader.getStream().filter((h) -> {
            return h.smoker;
        }).flatMapToInt((h) -> {
            return IntStream.of(h.gestation);
        }).average().orElse(0);
        double not_smoke_women = Reader.getStream().filter((h) -> {
            return !h.smoker;
        }).flatMapToInt((h) -> {
            return IntStream.of(h.gestation);
        }).average().orElse(0);
        System.out.println(smoke_women);
        System.out.println(not_smoke_women);
        System.out.println(smoke_women < not_smoke_women);
    }
}
