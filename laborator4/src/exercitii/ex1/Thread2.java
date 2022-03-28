package exercitii.ex1;

import java.util.concurrent.locks.Lock;

public class Thread2 extends Thread {
    private Lock l1, l2;
    private String name;
    private int intarziere, k;

    public Thread2(String name, Lock s1, Lock s2, int intarziere, int k) {
        this.name = name;
        this.l1 = s1;
        this.l2 = s2;
        this.intarziere = intarziere;
        this.k = k;
    }

    @Override
    public void run() {

        try {
            System.out.println(name + " - STATE 1");
            l1.lock();
            l2.lock();
            System.out.println("Firul " + name + " a luat doua jetoane.");
            System.out.println(name + " - STATE 2");

            for (int i = 0; i < k * 1000000; i++) {
                i++;
                i--;
            }


            System.out.println("Firul " + name + " a eliberat doua jetoane.");
            l1.unlock();
            l2.unlock();
            Thread.sleep(this.intarziere);

            System.out.println(name + " - STATE 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
