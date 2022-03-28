package laborator3.exemplu1;

public class FirS extends Thread {
    Resursa res;

    FirS(Resursa res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + "am scris: " + i);
            res.setR(i);
        }
    }
}
