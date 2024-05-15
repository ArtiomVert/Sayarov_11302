package cw240511;

import cw240511.XML.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Weather {
    static String APIKEY = "879683e3920e34a11fd62e0369ef6807";
    static String s1 = "https://api.openweathermap.org/data/2.5/weather?mode=xml&units=metric&q=";
    static String s4 = "&appid=";

    public static void main(String[] args) throws Exception {

        String link = s1 + "Zelenodolsk" + s4 + APIKEY;
        URL url = new URL(link);
        InputStream is = url.openStream();
        String s = "";
        int data = is.read();
        while (data != -1) {
            s += (char) data;
            data = is.read();
        }
        XML x = Parser.getXML(s);
        Teg start = x.tegs.get(0);
        try (FileOutputStream out = new FileOutputStream("work\\src\\cw240511\\file.csv", true)) {
            out.write("city,temperature,date\n".getBytes());
            Teg city = find(start, "city");
            Teg temperature = find(start, "temperature");
            Teg date = find(start, "lastupdate");
            String out_string = city.atr.get("name") + "," + temperature.atr.get("value") + "," + date.atr.get("value")+"\n";
            out.write(out_string.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Teg t : start.tegs) {
            print(t, 0);
        }
    }

    static String q(int c) {
        String s = "";
        for (int i = 0; i < c; i++) {
            s += "   ";
        }
        return s;
    }

    static void print(Teg t, int space) {
        String sp = q(space);
        System.out.print(sp + t.name + ": ");
        for (String a : t.atr.keySet()) {
            System.out.print(a + "=" + t.atr.get(a) + " ");
        }
        System.out.println();
        for (Teg t1 : t.tegs) {
            print(t1, space + 1);
        }
    }

    static Teg find(Teg start, String target_name_teg) {
        if (start.name.equals(target_name_teg)) {
            return start;
        }
        for (Teg t : start.tegs) {
            Teg f = find(t, target_name_teg);
            if (f != null) return f;
        }
        return null;
    }
}
