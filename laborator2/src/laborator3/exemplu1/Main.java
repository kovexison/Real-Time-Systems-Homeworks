package laborator3.exemplu1;

public class Main {
    public static void main(String[] args) {
        Resursa res = new Resursa();
        FirS fs = new FirS(res);
        FirC fc = new FirC(res);
        fs.start();
        fc.start();
    }
}
