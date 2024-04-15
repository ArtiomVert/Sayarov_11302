package Threads;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URL;
import java.util.ArrayList;

public class MainDownloader {
    public static void main(String[] args) throws Exception {
        ArrayList<String> srcs = new ArrayList<>();
        URL url = new URL("https://ru.freepik.com/videos/%D1%85%D0%B0%D0%BA%D0%B5%D1%80%D1%8B#from_element=tags_block");
        LineNumberReader reader = new LineNumberReader(new InputStreamReader(url.openStream()));
        String string = reader.readLine();
        while (!string.isEmpty()) {
            int a = string.indexOf("\"videoSrc\":\"") + 12;
            if (a == 11) break;
            string = string.substring(a);
            int i = 0;
            String ch = "" + string.charAt(i);
            String link = "";
            while (!ch.equals("\"")) {
                link += ch;
                i++;
                ch = "" + string.charAt(i);
            }
            srcs.add(link);
        }
        reader.close();

        Thread[] ts = new Thread[srcs.size()];
        for (int i = 0; i < srcs.size(); i++) {
            ts[i] = new Downloader(srcs.get(i));
            ts[i].start();
        }
        for (int i = 0; i < ts.length; i++) {
            ts[i].join();
            System.out.println(i + 1 + "/" + ts.length);
        }
    }
}
