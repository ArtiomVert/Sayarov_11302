package homeworks.DZ4;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Task26 {
    final static int FIRST_BYTE_RUS_SYMBOL_A_YA_a_p = 208;
    final static int SECOND_BYTE_RUS_SYMBOL_A_YA_a_p_MIN = 144;
    final static int SECOND_BYTE_RUS_SYMBOL_A_YA_a_p_MAX = 191;
    final static int SECOND_BYTE_RUS_SYMBOL_A_YA_a_p_SHIFT = 48;
    final static int FIRST_BYTE_RUS_SYMBOL_r_ya = 209;
    final static int SECOND_BYTE_RUS_SYMBOL_r_ya_MIN = 128;
    final static int SECOND_BYTE_RUS_SYMBOL_r_ya_MAX = 143;
    final static int SECOND_BYTE_RUS_SYMBOL_r_ya_SHIFT = 112;

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("work\\res\\task_for_dz4_26.txt");
             FileOutputStream out = new FileOutputStream("work\\res\\task_for_dz4_26_out.txt")) {
            int data = in.read();
            while (data != -1) {
                if (data == FIRST_BYTE_RUS_SYMBOL_A_YA_a_p) {
                    int data2 = in.read();
                    if (data2 == 129) {//Ё
                        out.write(168);
                    } else if (data2 <= SECOND_BYTE_RUS_SYMBOL_A_YA_a_p_MAX && data2 >= SECOND_BYTE_RUS_SYMBOL_A_YA_a_p_MIN) {//А-Я, а-п
                        out.write((data2 + SECOND_BYTE_RUS_SYMBOL_A_YA_a_p_SHIFT));
                    } else {
                        out.write(data);
                        out.write(data2);
                    }
                } else if (data == FIRST_BYTE_RUS_SYMBOL_r_ya) {
                    int data2 = in.read();
                    if (data2 == 145) {//ё
                        out.write(184);
                    } else if (data2 <= SECOND_BYTE_RUS_SYMBOL_r_ya_MAX && data2 >= SECOND_BYTE_RUS_SYMBOL_r_ya_MIN) {//р-я
                        out.write((data2 + SECOND_BYTE_RUS_SYMBOL_r_ya_SHIFT));
                    } else {
                        out.write(data);
                        out.write(data2);
                    }
                } else {
                    out.write(data);
                }
                data = in.read();
            }
        } catch (Exception e) {

        }

    }
}
