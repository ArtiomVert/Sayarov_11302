package homeworks.DZ4;

import homeworks.DZ4.HTML.HTML;
import homeworks.DZ4.HTML.Teg;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Stack;

public class Task28 {
    //Загрузить из интернета html страницу, распарсить её (опираясь на теги и построив дерево)
    // "work\\res\\task28_for_dz4.txt"
    static HTML getHTML(String html_string) {
        HTML html = new HTML();
        Stack<Teg> tegs = new Stack<>();
        while (html_string.contains("<")) {
            int index = html_string.indexOf("<");
            String new_s = html_string.substring(index);
            if (new_s.indexOf("</") == 0) {
                if (!tegs.peek().closed && new_s.indexOf("</" + tegs.peek().name) == 0) {
                    tegs.peek().atr.put("text", html_string.substring(0, index));
                    tegs.peek().closed = true;
                } else {
                    Stack<Teg> t = new Stack<>();
                    while (!(!tegs.peek().closed && new_s.indexOf("</" + tegs.peek().name) == 0)) {
                        t.push(tegs.pop());
                    }
                    tegs.peek().closed = true;
                    while (!t.empty()) {
                        tegs.peek().tegs.add(t.pop());
                    }
                }
            } else {
                String new_teg = "";
                int c = 1;
                String cur_char = "" + new_s.charAt(c);
                while (!(cur_char.equals(" ") || cur_char.equals(">"))) {
                    new_teg += new_s.charAt(c);
                    c++;
                    cur_char = "" + new_s.charAt(c);
                }
                Teg t = new Teg(new_teg);
                String s1 = "";
                String s2 = "";
                int sc = 0;
                while (!cur_char.equals(">")) {
                    switch (cur_char) {
                        case "\"": {
                            sc++;
                            if (sc == 2) {
                                t.atr.put(s1, s2);
                                sc = 0;
                                s1 = "";
                                s2 = "";
                            }
                            break;
                        }
                        case " ":
                        case "=": {
                            if (sc == 1) {
                                s2 += cur_char;
                            }
                            break;
                        }
                        default: {
                            if (sc == 0) {
                                s1 += cur_char;
                            } else {
                                s2 += cur_char;
                            }
                        }
                    }
                    c++;
                    cur_char = "" + new_s.charAt(c);
                }
                tegs.push(t);
            }
            html_string = new_s.substring(new_s.indexOf(">") + 1);
        }
        while (!tegs.empty()) {
            html.tegs.add(tegs.pop());
        }
        return html;
    }

    public static void main(String[] args) {
        String s = "";
        try (FileInputStream in = new FileInputStream("work\\res\\task28_for_dz4.txt")) {
            int data = in.read();
            ArrayList<Byte> bs = new ArrayList<>();
            while (data != -1) {
                bs.add((byte) data);
                data = in.read();
            }
            byte[] b = new byte[bs.size()];
            for (int i = 0; i < bs.size(); i++) {
                b[i] = bs.get(i);
            }
            s = new String(b);
        } catch (Exception e) {
        }
        HTML html = getHTML(s);
        for (Teg t : html.tegs) {
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
}
