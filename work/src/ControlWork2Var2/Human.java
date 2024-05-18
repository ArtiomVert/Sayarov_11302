package ControlWork2Var2;

public class Human {
    String pol;
    int plular;
    int age;
    String race;
    int parity;
    boolean married;
    int bwt;
    int smokeN;
    int drinkN;
    boolean firstep;
    boolean welfare;
    boolean smoker;
    boolean drinker;
    int wpre;
    int wgain;
    int education;
    int gestation;
    public Human(String s){
        String[] args = s.split("\\s+");
        pol = args[0];
        plular = Integer.parseInt(args[1]);
        age = Integer.parseInt(args[2]);
        race = args[3];
        parity = Integer.parseInt(args[4]);
        married = args[5].equals("1");
        bwt = Integer.parseInt(args[6]);
        smokeN = Integer.parseInt(args[7]);
        drinkN = Integer.parseInt(args[8]);
        firstep = args[9].equals("1");
        welfare = args[10].equals("1");
        smoker = args[11].equals("Y");
        drinker = args[12].equals("Y");
        wpre = Integer.parseInt(args[13]);
        wgain = Integer.parseInt(args[14]);
        education = Integer.parseInt(args[15]);
        gestation = Integer.parseInt(args[16]);
    }
}
