package Threads;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i1 = 0; i1 < 10; i1++) {
            (new Thread(){
                int i = 0;
                public Thread seti(int i){
                    this.i = i;
                    return this;
                }
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        System.out.println(i);
                    }
                }
            }).seti(i1).start();
        }
        Thread t = new Thread(){
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    System.out.println(j);
                }
            }
        };
        t.start();
        Thread.sleep(10);
        t.stop();
    }
}
