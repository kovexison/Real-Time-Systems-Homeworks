package exercitii.ex2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();
        FirExecutie1 f1 = new FirExecutie1("f1",l1,l2,new int[] {4000,5000},new int[] {2,4},new int[] {4,6});
        FirExecutie1 f2 = new FirExecutie1("f2", l1,l2,new int[] {5000,4000} ,new int[] {3,5}, new int[] {5,7});

        f1.start();
        f2.start();
    }
}
