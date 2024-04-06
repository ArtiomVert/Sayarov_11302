package cw240330;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class HtmlGenerator {
    private List<DIV> divs = new ArrayList<>();
    public void addDiv(String h, int size, String p){
        divs.add(new DIV(h, size, p));
    }
    public void addDiv(String h, String p){
        addDiv(h, 3, p);
    }
    public void gen() {
        try {
            FileOutputStream os = new FileOutputStream("MySheet.html");
            os.write("<!DOCTYPE html><html lang='en'><body>".getBytes());
            for (DIV d:divs){
                os.write(d.toString().getBytes());
            }
            os.write("</body></html>".getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
class DIV{
    String h;
    int size;
    String p;
    public DIV(String h, int size, String p){
        this.h = h;
        this.size = size;
        this.p = p;
    }

    @Override
    public String toString() {
        return "<div>"+"<h"+size+">"+h+"</h"+size+">"+"<p>"+p+"</p>"+"</div>";
    }
}
