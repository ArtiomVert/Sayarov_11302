import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        NS3S ns = new NS3S(3, 5, 5, 5, 2);
        double[][] asks = {
            {0,0,0},
            {0,0,1},
            {0,1,0},
            {0,1,1},
            {1,0,0},
            {1,0,1},
            {1,1,0},
            {1,1,1}
        };
        double[][] answers = {
            {0,0},
            {0,1},
            {0,1},
            {1,0},
            {0,1},
            {1,0},
            {1,0},
            {1,1}
        };
        int n = inp.nextInt();
        for (int i = 0; i < n; i++){
            System.out.print((i+1) + "/" + n + ":");
            ns.train(asks, answers);
        }
        System.out.println("Ready");
        for (int i = 0; i<asks.length; i++){
            ns.test(asks[i]);
        }
    }
}