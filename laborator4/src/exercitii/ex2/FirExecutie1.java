package exercitii.ex2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;


public class FirExecutie1 extends Thread {
    private Lock monitor1;
    private Lock monitor2;
    private String name;
    private int[] sleep;
    private int activity_min1, activity_max1, activity_min2, activity_max2;

    public FirExecutie1(String name, Lock monitor1, Lock monitor2, int[] sleeps, int[] activity_mins, int[] activity_maxes) {
        this.name = name;
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep = sleeps;
        this.activity_min1 = activity_mins[0];
        this.activity_max1 = activity_maxes[0];
        this.activity_min2 = activity_mins[1];
        this.activity_max2 = activity_maxes[1];
    }

    @Override
    public void run() {
        activity1(1);
        monitor1.lock();
        System.out.println("Thread " + name + " a luat zavorul 1");
            activity2(2);
            if(monitor2.tryLock()){
                System.out.println("Am intrat pe true");

        } else {
                System.out.println("Am intrat pe false. Astept 4 secunde");
            monitor1.unlock();
            try {
                Thread.sleep(sleep[1]);
                monitor1.lock();
                monitor2.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread " + name + " a luat zavorul 2");
        state3();
            monitor2.unlock();
            monitor1.unlock();
        System.out.println(this.name + " - STATE 4");
    }

    private void activity1(int state) {
        System.out.println(this.name + " - STATE " + state);
        int k = ThreadLocalRandom.current().nextInt(this.activity_min1,this.activity_max1);
        for (long i = 0; i < k * 1000000; i++) {
            i++;
            i--;
        }
    }

    private void state3() {
        System.out.println(this.name + " - STATE 3");
        try {
            Thread.sleep(this.sleep[0]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void activity2(int state) {
        System.out.println(this.name + " - STATE " + state);
        int k = ThreadLocalRandom.current().nextInt(this.activity_min2,this.activity_max2);
        for (long i = 0; i < k * 1000000; i++) {
            i++;
            i--;
        }
    }
}
