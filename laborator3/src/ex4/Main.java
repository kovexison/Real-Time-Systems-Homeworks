package ex4;

public class Main {
    public static void main(String[] args) {
        Monitor m1 = new Monitor();
        Monitor m2 = new Monitor();

        FirExecutie f1 = new FirExecutie("f1", m1, m2, 7, 2, 3);
        FirExecutie f2 = new FirExecutie("f2", m1, m2, 0, 3, 5);
        FirExecutie f3 = new FirExecutie("f3", m2, m1, 0, 4, 6);

        f1.start();
        f2.start();
        f3.start();

        try {
            f1.join();
            f2.join();
            f3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
