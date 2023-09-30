import java.util.Scanner;

public class GameCat {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int eat = (int)(Math.random()*10);
        int water = (int)(Math.random()*10);
        int laska = (int)(Math.random()*10);
        int days = 0;
        for (int i = 0; i<=31; i++){
            eat-=(int)(Math.random()*3);
            water-=(int)(Math.random()*3);
            laska-=(int)(Math.random()*3);
            System.out.println("./\\.../\\ ");
            System.out.println("(.'*..*')");
            System.out.println(" ..=*=..");
            System.out.println("(.\\.||./.)~~**");
            System.out.println("Параметры вашего кота:");
            System.out.println("Еда---->"+eat);
            System.out.println("Вода--->"+water);
            System.out.println("Ласка-->"+laska);
            if (laska<0 || water<0 || eat<0){
                System.out.println("Ваш кот умер");
                break;
            }
            System.out.println("Что вы хотите сделать?");
            System.out.println("Покормить----1");
            System.out.println("Напоить------2");
            System.out.println("Поласкать----3");
            String action = inp.next();
            switch (action){
                case "1":eat+=2;break;
                case "2":water+=2;break;
                case "3":laska+=2;break;
                default:break;
            }
            days+=1;
            for (int q=0;q<=10;q++){
                System.out.println();
            }
        }

        System.out.println("./\\.../\\ ");
        System.out.println("(.'X..X')");
        System.out.println(" ..=*=..");
        System.out.println("(.\\.||./.)~~**");
        System.out.println("Ваш кот прожил " + days + " дней.");
    }
}
