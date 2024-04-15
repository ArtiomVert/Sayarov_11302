package Threads;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Downloader extends Thread {
    private String link;

    public Downloader(String link) {
        this.link = link;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(link);
            InputStream is = url.openStream();
            String file_name = "res\\" + System.nanoTime() + link.hashCode() + link.charAt(link.length() / 2)+".mp4";
            OutputStream os = new FileOutputStream(file_name);
            int data = is.read();
            while (data != -1) {
                os.write(data);
                data = is.read();
            }
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
