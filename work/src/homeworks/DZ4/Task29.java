package homeworks.DZ4;

import homeworks.DZ4.HTML.HTML;
import homeworks.DZ4.HTML.Teg;

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
        HTML html = Task28.getHTML();
        for (Teg t: html.tegs){
            obhod(t);
        }
    }
}
