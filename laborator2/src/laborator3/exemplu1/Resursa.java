package laborator3.exemplu1;

public class Resursa {
    int r;

    synchronized void setR(int a) {
        this.r = a;
        notify();
        try {
            wait(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized int getR() {
        try {
            wait(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
        return this.r;
    }
}
