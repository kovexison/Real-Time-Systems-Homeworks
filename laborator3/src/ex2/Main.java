package ex2;

public class Main {
    public static void main(String[] args) {
        Integer m1 = 2;
        Integer m2 = 4;
        FirExecutie1 f1 = new FirExecutie1("f1",m1,m2,4,new int[] {2,4},new int[] {4,6});
        FirExecutie1 f2 = new FirExecutie1("f2", m1,m2,5,new int[] {3,5}, new int[] {5,7});

        f1.start();
        f2.start();
    }
}
