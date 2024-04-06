package Threads;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class Downloader {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> srcs = new ArrayList<>();
        try {
            URL url = new URL("https://ru.freepik.com/videos/%D1%85%D0%B0%D0%BA%D0%B5%D1%80%D1%8B#from_element=tags_block");
            LineNumberReader reader = new LineNumberReader(new InputStreamReader(url.openStream()));
            String string = reader.readLine();
            while (!string.isEmpty()) {
                int a = string.indexOf("\"videoSrc\":\"");
                if (a == -1) break;
                a += 12;
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
        } catch (Exception ex) {}

        Thread[] ts = new Thread[srcs.size()];
        for (int i = 0; i < srcs.size(); i++) {
            ts[i] = dowload(srcs.get(i));
        }
        for (int i = 0; i < ts.length; i++){
            ts[i].join();
            System.out.println(i+1+"/"+ts.length);
        }
    }

    static Thread dowload(String s) {
        Thread t = (new Thread(() -> {
            try {
                URL url = new URL(s);
                InputStream is = url.openStream();
                OutputStream os = new FileOutputStream(s.hashCode() + ".mp4");
                int data = is.read();
                while (data != -1) {
                    os.write(data);
                    data = is.read();
                }
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
        t.start();
        return t;
    }
}
