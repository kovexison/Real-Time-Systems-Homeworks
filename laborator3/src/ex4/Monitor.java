package ex4;

public class Monitor {

    public synchronized void notifica() {
        System.out.println("notifying ");
        notify();
    }

    public synchronized void asteapta() {
        System.out.println("waiting... ");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
