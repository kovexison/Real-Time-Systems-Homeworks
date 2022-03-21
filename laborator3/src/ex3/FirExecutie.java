package ex3;

import java.util.concurrent.ThreadLocalRandom;

public class FirExecutie extends Thread {
    private String name;
    private Integer m;
    private int sleep;
    private int activity_min, activity_max;

    public FirExecutie(String name, Integer m, int sleep, int activity_min, int activity_max) {
        this.name = name;
        this.m = m;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.name + " - STATE 1");
            synchronized (m) {
                System.out.println(this.name + " - STATE 2");
                activity();
            }
            System.out.println(this.name + " - STATE 3");
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + " - STATE 4");
            System.out.println(" ---------------- ");
        }
    }

    private void activity() {
        int k = ThreadLocalRandom.current().nextInt(this.activity_min,this.activity_max);
        for (int i = 0; i < k * 1000000; i++) {
            i++;
            i--;
        }
    }
}
