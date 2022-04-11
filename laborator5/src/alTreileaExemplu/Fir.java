package alTreileaExemplu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Fir extends Thread {
    private int sleep;
    private int activity_min;
    private int activity_max;
    private Semaphore semaphore;
    private CountDownLatch countDownLatch;
    private  Semaphore semaphore2;


    public Fir(int sleep, int activity_max, int activity_min, Semaphore semaphore,Semaphore semaphore2, CountDownLatch countDownLatch) {
        this.sleep = sleep;
        this.activity_max = activity_max;
        this.activity_min = activity_min;
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.semaphore2 = semaphore2;
    }

    @Override
    public void run() {

        System.out.println(this.getName() + " STATE 1");

        if(sleep == 0){
            try {
                semaphore.acquire();
                System.out.println(this.getName() + " a luat jetonul");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        System.out.println(this.getName() + " STATE 2");

        activitate(activity_min, activity_max);

        if(sleep != 0){
            semaphore.release();
            semaphore2.release();
            System.out.println(this.getName() + " A incarcat monitoarele");
        }

        System.out.println(this.getName() + " STATE 3");
        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void activitate(int activ_min, int activ_max) {
        long activ = (long) Math.round(Math.random() * (activ_max - activ_min) + activ_max);
        for (long i = 0; i < activ * 2.2 * 4 * 100000; i++) {
            i++;
            i--;
        }
    }
}
