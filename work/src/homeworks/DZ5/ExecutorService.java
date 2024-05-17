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
    private DownloadThread[] threads;
    private ArrayList<String> ready;

    public ExecutorService(int n) {
        que = new ArrayDeque<>();
        ready = new ArrayList<>();
        this.n = n;
        threads = new DownloadThread[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new DownloadThread(que, ready);
            threads[i].start();
        }
    }

    public void addToQueue(String link, String name) {
        synchronized (que) {
            que.add(new Pair(link, name));
        }
    }

    public void getStatus(String name) {
        for (DownloadThread t : threads) {
            if (t.workPair.name.equals(name)) {
                System.out.println(t.getProcent() + "%");
                return;
            }
        }
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

class DownloadThread extends Thread {

    ArrayDeque<Pair> que;
    ArrayList<String> ready;
    Pair workPair;
    URL url;
    int readed = 0;
    int fileSize = 0;

    public DownloadThread(ArrayDeque<Pair> que, ArrayList<String> ready) {
        this.que = que;
        this.ready = ready;
    }

    private boolean work(Pair p) {
        String file_name = "work\\res\\videos_task29-30\\" + p.name + ".mp4";
        try {
            url = new URL(p.link);
            fileSize = url.openConnection().getContentLength();
        } catch (Exception e) {
            url = null;
            return false;
        }
        try (InputStream is = url.openStream();
             OutputStream os = new FileOutputStream(file_name)) {
            readed = 0;
            int data = is.read();
            while (data != -1) {
                os.write(data);
                data = is.read();
                readed++;
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            url = null;
        }
    }

    public int getProcent() {
        if (workPair != null) {
            return readed * 100 / fileSize;
        }
        return 0;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (que) {
                if (!que.isEmpty()) {
                    workPair = que.pop();
                }
            }
            if (workPair != null) {
                if (work(workPair)) {
                    ready.add(workPair.name);
                } else {
                    synchronized (que) {
                        que.add(workPair);
                    }
                }
                workPair = null;
            }
        }
    }
}