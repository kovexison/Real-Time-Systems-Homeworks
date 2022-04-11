package alTreileaExemplu;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(0);
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Fir f1 = new Fir(7000,2000,3000,s1,s2,countDownLatch);
        Fir f2 = new Fir(0,5000,3000,s1,s2,countDownLatch);
        Fir f3 = new Fir(0,6000,4000,s2,s1,countDownLatch);

        f1.setName("f1");
        f2.setName("f2");
        f3.setName("f3");

        f1.start();
        f2.start();
        f3.start();
    }
}
