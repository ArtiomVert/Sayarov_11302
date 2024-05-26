package cw240511;

import cw240511.XML.*;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Weather {
    static String APIKEY = "879683e3920e34a11fd62e0369ef6807";
    static String s1 = "https://api.openweathermap.org/data/2.5/weather?mode=xml&units=metric&q=";
    static String s4 = "&appid=";

    static XML getXML(String city) {
        String link = s1 + city + s4 + APIKEY;
        URL url;
        try {
            url = new URL(link);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        String s;
        try (InputStream is = url.openStream()) {
            byte[] bs = new byte[url.openConnection().getContentLength()];
            is.read(bs);
            s = new String(bs);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        XML xml = Parser.getXML(s);
        return xml;
    }

    static void writeData(Teg start) {
        try (FileOutputStream out = new FileOutputStream("work\\src\\cw240511\\file.csv", true)) {
            Teg city = find(start, "city");
            Teg temperature = find(start, "temperature");
            Teg date = find(start, "lastupdate");
            Teg pressure = find(start, "pressure");
            Teg weather = find(start, "weather");
            String out_string = city.atr.get("name") + ";" + temperature.atr.get("value")
                    + ";" + date.atr.get("value") + ";" + pressure.atr.get("value")
                    + pressure.atr.get("unit") + ";" + weather.atr.get("value") + "\n";
            out.write(out_string.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String[] cities = new String[]{"Kazan", "Zelenodolsk", "Moscow", "Kursk", "Smolensk", "Samara", "Novosibirsk"};
        for (String city : cities) {
            Teg start = getXML(city).tegs.get(0);
            writeData(start);
            for (Teg t : start.tegs) {
                print(t, 0);
            }
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
