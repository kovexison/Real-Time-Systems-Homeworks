package ex1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class Thread1 extends Thread {
    private Semaphore l;
    private CyclicBarrier cb;
    private String name;
    private int intarziere, k;

    public Thread1(String name, Semaphore s, CyclicBarrier cb, int intarziere, int k) {
        this.name = name;
        this.l = s;
        this.intarziere = intarziere;
        this.k = k;
        this.cb = cb;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(name + " - STATE 1");
                l.acquire();
                System.out.println("Firul " + name + " a luat un jeton.");
                System.out.println(name + " - STATE 2");
                for (int i = 0; i < k * 1000000; i++) {
                    i++;
                    i--;
                }
                System.out.println("Firul " + name + " a eliberat un jeton.");
                l.release();
                Thread.sleep(this.intarziere);
                System.out.println(name + " - STATE 3");
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }
}
