package exercitii.ex1;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock s1 = new ReentrantLock();
        Lock s2 = new ReentrantLock();
        Thread1 f1, f3;
        Thread2 f2 = new Thread2("f2", s1, s2, 3000, ThreadLocalRandom.current().nextInt(3,6));
        f1 = new Thread1("f1", s1, 4000, ThreadLocalRandom.current().nextInt(2,4));
        f3 = new Thread1("f3", s2, 5000, ThreadLocalRandom.current().nextInt(2,5));

        f1.start();
        f2.start();
        f3.start();
    }
}
