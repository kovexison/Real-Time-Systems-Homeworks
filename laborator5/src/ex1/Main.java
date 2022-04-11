package ex1;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(1);  //S1 din RP este obiect de tip Semaphore
        Semaphore s2 = new Semaphore(1);  //S2 din RP este Semaphore
        CyclicBarrier cb = new CyclicBarrier(3, new Runnable() { //parties: numarul de fire care se intalnesc la bariera
            @Override
            public void run() {
                System.out.println();
                System.out.println("Rutina barierei cb");
                System.out.println("-----------------------");
                System.out.println();
            }
        }); //cb din reteaua petri este un obiect de tip CyclicBarrier

        Thread1 f1, f3;
        Thread2 f2 = new Thread2("f2", s1, s2, cb, 3000, ThreadLocalRandom.current().nextInt(3,6));
        f1 = new Thread1("f1", s1, cb, 4000, ThreadLocalRandom.current().nextInt(2,4));
        f3 = new Thread1("f3", s2, cb,5000, ThreadLocalRandom.current().nextInt(2,5));

        f1.start();
        f2.start();
        f3.start();
    }
}
