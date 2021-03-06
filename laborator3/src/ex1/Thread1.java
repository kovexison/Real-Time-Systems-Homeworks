package ex1;

import java.util.concurrent.Semaphore;

public class Thread1 extends Thread {
    private Integer s;
    private String name;
    private int intarziere, k;

    public Thread1(String name, Integer s, int intarziere, int k) {
        this.name = name;
        this.s = s;
        this.intarziere = intarziere;
        this.k = k;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " - STATE 1");
            synchronized (s) {
                System.out.println("Firul " + name + " a luat un jeton.");
                System.out.println(name + " - STATE 2");

                for (int i = 0; i < k * 1000000; i++) {
                    i++;
                    i--;
                }
                System.out.println("Firul " + name + " a eliberat un jeton.");
                Thread.sleep(this.intarziere);
            }
            System.out.println(name + " - STATE 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
