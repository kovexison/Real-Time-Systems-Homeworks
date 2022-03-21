package ex1;

import java.util.concurrent.Semaphore;

public class Thread2 extends Thread {
    private Integer s1, s2;
    private String name;
    private int intarziere, k;

    public Thread2(String name, Integer s1, Integer s2, int intarziere, int k) {
        this.name = name;
        this.s1 = s1;
        this.s2 = s2;
        this.intarziere = intarziere;
        this.k = k;
    }

    @Override
    public void run() {

        try {
            System.out.println(name + " - STATE 1");
            synchronized (s1) {
                synchronized (s2) {
                    System.out.println("Firul " + name + " a luat doua jetoane.");
                    System.out.println(name + " - STATE 2");

                    for (int i = 0; i < k * 1000000; i++) {
                        i++;
                        i--;
                    }
                }

                System.out.println("Firul " + name + " a eliberat doua jetoane.");
                Thread.sleep(this.intarziere);
            }
            System.out.println(name + " - STATE 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
