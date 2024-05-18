package ControlWork2Var2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Reader {
    static Stream<Human> getStream() {
        try (BufferedReader is = new BufferedReader(new FileReader("work\\src\\ControlWork2Var2\\BirthsKingCounty2001.txt"))) {
            String s = is.readLine();
            ArrayList<Human> hs = new ArrayList<>();
            while (s != null) {
                hs.add(new Human(s));
                s = is.readLine();
            }
            return hs.stream();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
