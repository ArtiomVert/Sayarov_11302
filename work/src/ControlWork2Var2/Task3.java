package ControlWork2Var2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Task3 {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("work\\src\\ControlWork2Var2\\DataSet")) {
            Reader.getStream().forEach((h -> {
                try {
                    out.write((byte) h.race.getBytes().length);
                    out.write(h.race.getBytes());
                    out.write((byte) h.education);
                } catch (Exception e) {
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileInputStream is = new FileInputStream("work\\src\\ControlWork2Var2\\DataSet")) {
            int length = is.read();
            while (length != -1) {
                byte[] bs = new byte[length];
                for (int i = 0; i < length; i++) {
                    bs[i] = (byte) is.read();
                }
                String race = new String(bs);
                System.out.println(race + " " + is.read());
                length = is.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
