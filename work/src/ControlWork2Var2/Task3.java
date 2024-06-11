package ControlWork2Var2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task3 {
    static void write() {
        Map<String, Integer> races = new HashMap<>();
        Reader.getStream().forEach(h -> races.put(h.race, null));
        try (FileOutputStream out = new FileOutputStream("work\\src\\ControlWork2Var2\\DataSet")) {
            out.write(races.size());
            int i = 0;
            for (Map.Entry<String, Integer> s : races.entrySet()) {
                out.write(s.getKey().getBytes().length);
                out.write(s.getKey().getBytes());
                s.setValue(i);
                i++;
            }
            Reader.getStream().forEach((h -> {
                try {
                    out.write(races.get(h.race));
                    out.write(h.education);
                } catch (Exception e) {
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void read() {
        try (FileInputStream is = new FileInputStream("work\\src\\ControlWork2Var2\\DataSet")) {
            int count_races = is.read();
            String[] races = new String[count_races];
            for (int i = 0; i < count_races; i++) {
                int length = is.read();
                byte[] race_in_byte = new byte[length];
                is.read(race_in_byte);
                races[i] = new String(race_in_byte);
            }
            int index_race = is.read();
            while (index_race != -1) {
                int education = is.read();
                System.out.println(races[index_race] + " " + education);
                index_race = is.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        write();
        read();
    }
}
