package cw240330;

public class Main {
    public static void main(String[] args) {
        HtmlGenerator html = new HtmlGenerator();
        html.addDiv("One", 1, "q");
        html.addDiv("Two", 2, "qq");
        html.addDiv("Three", 3, "qqq");
        html.addDiv("Four", 4, "qqqq");
        html.addDiv("Five", 5, "qqqqq");
        html.addDiv("Six", 6, "qqqqqq");
        html.gen();
    }
}
