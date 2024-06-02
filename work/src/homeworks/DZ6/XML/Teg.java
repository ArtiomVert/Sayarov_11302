package homeworks.DZ6.XML;

import java.util.ArrayList;
import java.util.HashMap;

public class Teg {
    public String name;
    public HashMap<String, String> atr = new HashMap<>();
    public ArrayList<Teg> tegs = new ArrayList<>();
    public boolean closed = false;
    public Teg(String name){
        this.name = name;
    }
}
