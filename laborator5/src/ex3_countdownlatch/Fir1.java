package ex3_countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Fir1 extends Thread {
    private String name;
    private int intarziere, k;
    private CountDownLatch cdl;
    private Semaphore s1, s2;

    public Fir1(String name, Semaphore s1, Semaphore s2, CountDownLatch cdl, int intarziere, int k) {
        this.cdl = cdl;
        this.s1 = s1;
        this.s2 = s2;
        this.intarziere = intarziere;
        this.k = k;
        this.name = name;
    }


    @Override
    public void run() {
        try {
            System.out.println(name + " - STATE 1");
            Thread.sleep(this.intarziere);

            System.out.println(name + " - STATE 2");
            for (int i = 0; i < k * 1000000; i++) {
                i++;
                i--;
            }
            s1.release();
            s2.release();
            System.out.println("Firul " + name + " a eliberat cate un jeton in semafoarele S1 si S2");
            System.out.println(name + " - STATE 3");

            cdl.countDown();
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
