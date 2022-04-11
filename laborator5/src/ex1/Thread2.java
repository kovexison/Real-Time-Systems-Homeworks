package ex1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class Thread2 extends Thread {
    private Semaphore l1, l2;
    private CyclicBarrier cb;
    private String name;
    private int intarziere, k;

    public Thread2(String name, Semaphore s1, Semaphore s2, CyclicBarrier cb, int intarziere, int k) {
        this.name = name;
        this.l1 = s1;
        this.l2 = s2;
        this.intarziere = intarziere;
        this.k = k;
        this.cb = cb;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(name + " - STATE 1");
                l1.acquire();
                l2.acquire();
                System.out.println("Firul " + name + " a luat doua jetoane: una din S1 si una din S2");
                System.out.println(name + " - STATE 2");

                for (int i = 0; i < k * 1000000; i++) {
                    i++;
                    i--;
                }


                System.out.println("Firul " + name + " a eliberat doua jetoane: una in S1 si una in S2");
                l1.release();
                l2.release();
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
