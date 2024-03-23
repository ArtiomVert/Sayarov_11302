package cw240322;

import java.io.*;

public class Main {
    public static String get(FileInputStream in) throws IOException {
        String s = "";
        int a;
        do {
            a = in.read();
            s += (char) a;
        } while (a != 10);
        return s;
    }

    public static void main(String[] args) throws RuntimeException, IOException {
        //OutputStream out = new FileOutputStream("abc");
        FileInputStream in = new FileInputStream("abc.txt");
        System.out.println(get(in));
    }
}
