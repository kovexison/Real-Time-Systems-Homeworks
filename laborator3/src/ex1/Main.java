package ex1;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Integer s1 = 3;
        Integer s2 = 1;
        Thread1 f1, f3;
        Thread2 f2 = new Thread2("f2", s1, s2, 3000, ThreadLocalRandom.current().nextInt(3,6));
        f1 = new Thread1("f1", s1, 4000, ThreadLocalRandom.current().nextInt(2,4));
        f3 = new Thread1("f3", s2, 5000, ThreadLocalRandom.current().nextInt(2,5));

        f1.start();
        f2.start();
        f3.start();
    }
}
