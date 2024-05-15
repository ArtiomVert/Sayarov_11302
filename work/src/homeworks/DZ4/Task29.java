package homeworks.DZ4;

import homeworks.DZ4.HTML.HTML;
import homeworks.DZ4.HTML.Teg;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Task29 {
    static void obhod(Teg teg){
        for (Teg t: teg.tegs){
            obhod(t);
        }
        if (teg.atr.get("text")!=null){
            System.out.println(teg.atr.get("text"));
        }
    }
    public static void main(String[] args) {
        String s = "";
        try (FileInputStream in = new FileInputStream("work\\res\\task28_for_dz4.txt")) {
            int data = in.read();
            ArrayList<Byte> bs = new ArrayList<>();
            while (data != -1) {
                bs.add((byte) data);
                data = in.read();
            }
            byte[] b = new byte[bs.size()];
            for (int i = 0; i < bs.size(); i++) {
                b[i] = bs.get(i);
            }
            s = new String(b);
        } catch (Exception e) {
        }
        HTML html = Task28.getHTML(s);
        for (Teg t: html.tegs){
            obhod(t);
        }
    }
}
