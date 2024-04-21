package homeworks.DZ5;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class ExecutorService {

    private int n;
    private ArrayDeque<Pair> que;
    private Thread[] threads;
    private ArrayList<String> ready;

    public ExecutorService(int n) {
        que = new ArrayDeque<>();
        ready = new ArrayList<>();
        this.n = n;
        threads = new Thread[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new Thread() {
                private boolean work(Pair p) {
                    try {
                        URL url = new URL(p.link);
                        InputStream is = url.openStream();
                        String file_name = "work\\res\\videos_task29-30\\" + p.name + ".mp4";
                        OutputStream os = new FileOutputStream(file_name);
                        int data = is.read();
                        while (data != -1) {
                            os.write(data);
                            data = is.read();
                        }
                        os.close();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }

                @Override
                public void run() {
                    boolean isWork = false;
                    Pair p = null;
                    while (true) {
                        synchronized (que) {
                            if (!que.isEmpty()) {
                                p = que.pop();
                                isWork = true;
                            }
                        }
                        if (isWork) {
                            if (work(p)) {
                                ready.add(p.name);
                            } else {
                                synchronized (que) {
                                    que.add(p);
                                }
                            }
                            isWork = false;
                        }
                    }
                }
            };
            threads[i].start();
        }

    }

    public void addToQueue(String link, String name) {
        synchronized (que) {
            que.add(new Pair(link, name));
        }
    }

    public void getStatus(String name) {
        if (ready.contains(name)) {
            System.out.println("100%");
        } else {
            System.out.println("0%");
        }
    }
}

class Pair {
    String link;
    String name;

    public Pair(String link, String name) {
        this.link = link;
        this.name = name;
    }
}