package homeworks.DZ4;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Task26 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("work\\res\\task_for_dz4_26.txt");
        FileOutputStream out = new FileOutputStream("work\\res\\task_for_dz4_26_out.txt");
        ArrayList<Byte> bs = new ArrayList<>();
        int data = in.read();
        while (data != -1) {
            if (data == 208) {
                int data2 = in.read();
                if (data2 == 129) {//Ё
                    out.write(168);
                } else if (data2 <= 191 && data2 >= 144) {//А-Я, а-п
                    out.write((data2 + 48));
                } else {
                    out.write(data);
                    out.write(data2);
                }
            } else if (data == 209) {
                int data2 = in.read();
                if (data2 == 145) {//ё
                    out.write(184);
                } else if (data2 <= 143 && data2 >= 128) {//р-я
                    out.write((data2 + 112));
                } else {
                    out.write(data);
                    out.write(data2);
                }
            } else {
                out.write(data);
            }
            data = in.read();
        }
        in.close();
        out.close();
    }
}
