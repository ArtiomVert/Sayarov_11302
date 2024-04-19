package homeworks.DZ4;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task26 {
    public static void main(String[] args) throws Exception{
        FileInputStream in = new FileInputStream("work\\res\\task_for_dz4_26.txt");
        FileOutputStream out = new FileOutputStream("work\\res\\task_for_dz4_26_out.txt");
        byte[] bytes = new byte[110];
        in.read(bytes);
        String s_utf8 = new String(bytes, "UTF-8");
        String s_w1251 = new String(bytes, "windows-1251");
        System.out.println(s_w1251);
        System.out.println(s_utf8);
        out.write(s_w1251.getBytes());
    }
}
