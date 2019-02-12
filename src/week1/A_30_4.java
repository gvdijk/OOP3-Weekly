package week1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A_30_4 {
    private static ExecutorService pool = Executors.newFixedThreadPool(1000);
    private static Integer i;

    public static void main(String[] args) {
        try {
            while (true) {
                i = 0;
                for (int i = 0; i<1000; i++) {
                    pool.execute(new Worker());
                }
                Thread.sleep(1000);
                System.out.println(i);
            }
        }
        catch (Exception e) { System.out.println(e); }
    }

    synchronized static void increment() { i++; }
}

class Worker implements Runnable {
    public void run() {
        A_30_4.increment();
    }
}
