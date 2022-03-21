package ex2;

import java.util.concurrent.ThreadLocalRandom;


public class FirExecutie1 extends Thread {
    private Integer monitor1;
    private Integer monitor2;
    private String name;
    private int sleep;
    private int activity_min1, activity_max1, activity_min2, activity_max2;

    public FirExecutie1(String name, Integer monitor1, Integer monitor2, int sleep, int[] activity_mins, int[] activity_maxes) {
        this.name = name;
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep = sleep;
        this.activity_min1 = activity_mins[0];
        this.activity_max1 = activity_maxes[0];
        this.activity_min2 = activity_mins[1];
        this.activity_max2 = activity_maxes[1];
    }

    @Override
    public void run() {
        activity1(1);
        synchronized (monitor1) {
            synchronized (monitor2) {
            activity2(2);
                System.out.println(this.name + " - STATE 3");
                try {
                    Thread.sleep(this.sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(this.name + " - STATE 4");
    }

    private void activity1(int state) {
        System.out.println(this.name + " - STATE " + state);
        int k = ThreadLocalRandom.current().nextInt(this.activity_min1,this.activity_max1);
        for (int i = 0; i < k * 1000000; i++) {
            i++;
            i--;
        }
    }

    private void activity2(int state) {
        System.out.println(this.name + " - STATE " + state);
        int k = ThreadLocalRandom.current().nextInt(this.activity_min2,this.activity_max2);
        for (int i = 0; i < k * 1000000; i++) {
            i++;
            i--;
        }
    }
}
