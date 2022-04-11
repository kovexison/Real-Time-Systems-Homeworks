package ex2_lab7f_fig7_1;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();
        CyclicBarrier cb = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println();
                System.out.println("Rutina barierei se executa");
                System.out.println("---------------------------");
                System.out.println();
            }
        });
        FirExecutie f1 = new FirExecutie("f1", l1, l2, cb, new int[] {4000,5000}, new int[] {2,4}, new int[] {4,6});
        FirExecutie f2 = new FirExecutie("f2", l1, l2, cb, new int[] {5000,4000}, new int[] {3,5}, new int[] {5,7});
        f1.start();
        f2.start();
    }
}
