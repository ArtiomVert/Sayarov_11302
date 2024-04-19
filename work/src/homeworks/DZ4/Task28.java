package homeworks.DZ4;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Task28 {
    //Загрузить из интернета html страницу, распарсить её (опираясь на теги и построив дерево)
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://cs1.htmlacademy.ru/content/blog/1331/index.html");
        InputStream in = url.openStream();
        FileOutputStream out = new FileOutputStream("task28_for_dz4.txt");
        int data = in.read();
        while (data!=-1){
            out.write(data);
            data = in.read();
        }
        out.close();
    }
}
