package laborator2;

public class Main {


    public static void main(String[] args) {
        Suma suma1 = new Suma();
        Suma suma2 = new Suma();
        Suma suma3 = new Suma();
        suma1.setPriority(10);
        suma2.setPriority(10);
        suma3.setPriority(10);

        suma1.setPas(5);
        suma2.setPas(3);
        suma3.setPas(4);
        suma1.start();
        suma2.start();
        suma3.start();

        System.out.println(suma1.getSuma());
        System.out.println(suma2.getSuma());
        System.out.println(suma3.getSuma());
        int ST = suma1.getSuma() + suma2.getSuma() + suma3.getSuma();
        System.out.println("laborator2.Suma totala este: " + ST);
    }
}
