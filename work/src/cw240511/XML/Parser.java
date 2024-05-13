package cw240511.XML;

import java.util.Stack;

public class Parser {
    //Загрузить из интернета html страницу, распарсить её (опираясь на теги и построив дерево)
    public static XML getXML(String s) {
        Stack<Teg> tegs = new Stack<>();
        while (s.contains("<")) {
            int index = s.indexOf("<");
            String new_s = s.substring(index);
            if (new_s.indexOf("</") == 0) {
                if (!tegs.peek().closed && new_s.indexOf("</" + tegs.peek().name) == 0) {
                    tegs.peek().atr.put("text", s.substring(0, index));
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
            s = new_s.substring(new_s.indexOf(">") + 1);
        }
        XML xml = new XML();
        while (!tegs.empty()) {
            xml.tegs.add(tegs.pop());
        }
        return xml;
    }
}
