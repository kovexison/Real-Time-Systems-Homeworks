package ex3;

public class Main {
    public static void main(String[] args) {
        Integer m = 2;
        FirExecutie f1 = new FirExecutie("f1", m, 5, 3, 6);
        FirExecutie f2 = new FirExecutie("f2", m, 3, 4, 7);
        FirExecutie f3 = new FirExecutie("f3", m, 6, 5, 7);

        f1.start();
        f2.start();
        f3.start();
    }
}
