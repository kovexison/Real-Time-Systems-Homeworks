package ex4;

import java.util.concurrent.ThreadLocalRandom;

public class FirExecutie extends Thread {
    private String name;
    private Monitor m1, m2;
    private int activity_min, activity_max;
    private int sleep;

    public FirExecutie(String name, Monitor m1, Monitor m2, int sleep, int activity_min, int activity_max) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        if(this.sleep != 0) {
            activity1();
        } else activity2();
    }

    private void activity1() {
        System.out.println(this.name + " - START");
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + " - STATE 1");
        int k = ThreadLocalRandom.current().nextInt(this.activity_min,this.activity_max);
        for (int i = 0; i < k * 1000000; i++) {
            i++;
            i--;
        }
        this.m1.notifica();
        this.m2.notifica();
        System.out.println(this.name + " - STATE 2");

    }

    private void activity2() {
        System.out.println(this.name + " - START");
        this.m1.asteapta();
        System.out.println(this.name + " - STATE 1");
        int k = ThreadLocalRandom.current().nextInt(this.activity_min,this.activity_max);
        for (int i = 0; i < k * 1000000; i++) {
            i++;
            i--;
        }
        System.out.println(this.name + " - STATE 2");
    }
}
