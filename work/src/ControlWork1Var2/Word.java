package ControlWork1Var2;

public class Word {
    private String source;
    private MyList translate = new MyList();
    private Word next = null;

    public Word getNext() {
        return next;
    }

    public void setNext(Word next) {
        this.next = next;
    }

    public void addTranslate(String t) {
        translate.add(t);
    }

    public Word(String source, String t) {
        this.source = source;
        addTranslate(t);
    }

    public String getSource() {
        return source;
    }

    public String[] getTranslate() {
        return translate.toArray();
    }

    public int getSize() {
        return translate.size();
    }

    @Override
    public String toString() {
        String out = source + " - ";
        if (translate.size() == 1) {
            out += translate.get(0) + ";";
            return out;
        }
        for (int i = 1; i <= translate.size(); i++) {
            out += i + ". " + translate.get(i - 1) + "; ";
        }
        return out;
    }
}
