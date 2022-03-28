package exemple.exemp1;

import java.util.concurrent.locks.Lock;

public class Fir extends Thread {
    //Fire de executie in Java SE - Pachetul Java.util.concurrent - Partea 1
    //exemplu de implementare a excluderii mutuale prin zavoare
    int nume;
    Lock l;

    Fir(int n, Lock la) {
        this.nume = n;
        this.l = la;
    }

    @Override
    public void run() {
        this.l.lock();
        System.out.println("Fir " + nume + " a pus zavorul.");
        regiuneCritica();
        System.out.println("Fir " + nume + " a eliberat zavorul.");
        this.l.unlock();
    }

    public void regiuneCritica() {
        System.out.println("SE EXECUTA REGIUNEA CRITICA BASZDMEG!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
