package ControlWork1Var2;

public class Main {
    public static void main(String[] args) {
        Dictionary d = new Dictionary("eng");
        d.insert("a", "A");
        d.insert("a", "AAA");
        d.insert("b", "B");
        d.insert("c", "C");
        d.insert("d", "D");
        d.insert("e", "E");
        d.insert("f", "F");
        d.insert("g", "G");
        d.insert("h", "H");
        d.insert("i", "I");
        d.insert("j", "JJ");
        d.insert("j", "JJJJ");
        d.insert("k", "KK");
        d.insert("l", "LL");
        d.insert("m", "MM");
        d.insert("n", "NN");
        d.insert("o", "OOO");
        d.insert("a", "AAAAA");
        System.out.println(d.numLen1());
        System.out.println(d.unique());
        d.show();
        System.out.println(d.translate("a e i j cc c f d"));
        d.delete("d");
        d.delete("a");
        d.delete("o");
        d.show();
    }
}
