package ControlWork1Var2;

import homeworks.DZ1.Node;

import java.util.HashSet;
import java.util.Set;

public class Dictionary {
    String lang;
    private int size = 0;
    private Word head = null;
    private Word end = null;

    public Dictionary(String lang) {
        this.lang = lang;
        head = null;
    }

    public void show() {
        Word cur = head;
        while (cur != null) {
            System.out.println(cur.toString());
            cur = cur.getNext();
        }
    }

    public void insert(String source, String new_translate) {
        if (size == 0) {
            head = new Word(source, new_translate);
            end = head;
            size++;
            return;
        }
        Word cur = head;
        while (cur != null) {
            if (cur.getSource().equals(source)) {
                cur.addTranslate(new_translate);
                return;
            }
            cur = cur.getNext();
        }
        end.setNext(new Word(source, new_translate));
        end = end.getNext();
        size++;
    }

    public void delete(String k) {
        if (head == null) return;
        if (head.getSource().equals(k)) {
            head = head.getNext();
            size--;
            return;
        }
        if (end.getSource().equals(k)) {
            Word cur = head;
            for (int i = 1; i < size - 1; i++) {
                cur = cur.getNext();
            }
            end = cur;
            end.setNext(null);
            size--;
            return;
        }
        Word cur = head;
        while (!cur.getNext().getSource().equals(k)) {
            cur = cur.getNext();
        }
        cur.setNext(cur.getNext().getNext());
        size--;
    }

    public Set<String> unique() {
        Set<String> words = new HashSet<>();
        Word cur = head;
        while (cur != null) {
            if (cur.getSize() == 1) words.add(cur.getSource());
            cur = cur.getNext();
        }
        return words;
    }

    public String translate(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            Word cur = head;
            while (cur != null) {
                if (cur.getSource().equals(words[i])) {
                    words[i] = cur.getTranslate()[0];
                    break;
                }
                cur = cur.getNext();
            }
        }
        String out_text = "";
        for (String word : words) {
            if (!out_text.isEmpty()) out_text += " ";
            out_text += word;
        }
        return out_text;
    }

    public int numLen1() {
        int count = 0;
        Word cur = head;
        while (cur != null) {
            boolean f = true;
            for (String word : cur.getTranslate()) {
                if (cur.getSource().length() + 1 < word.length()) {
                    f = false;
                    break;
                }
            }
            if (f) count++;
            cur = cur.getNext();
        }
        return count;
    }
}
