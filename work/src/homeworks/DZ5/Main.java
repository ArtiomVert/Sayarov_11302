package homeworks.DZ5;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ExecutorService es = new ExecutorService(5);
        Scanner fs = new Scanner(new FileInputStream("work\\res\\videos_task29-30\\links.txt"));
        for (int i = 0; i < 50; i++) {
            es.addToQueue(fs.nextLine(), i+"");
        }
        while (true){
            String[] com = sc.nextLine().split(" ");
            switch (com[0]){
                case "d":{
                    es.addToQueue(com[1], com[2]);
                    break;
                }
                case "s":{
                    es.getStatus(com[1]);
                    break;
                }
            }
        }
    }
}
