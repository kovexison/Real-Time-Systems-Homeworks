package laborator3.exemplu1;

public class FirC extends Thread {
    Resursa res;

    FirC(Resursa res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + "am citit: " + res.getR());
        }
    }
}
