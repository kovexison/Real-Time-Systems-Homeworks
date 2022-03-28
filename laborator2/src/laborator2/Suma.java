package laborator2;

public class Suma extends Thread {
    private int pas;
    private int suma = 0;

    @Override
    public void start() {
        super.start();
        this.run();
    }
    @Override
    public void run() {
        for(int i=0;i<=60;i += pas){
            this.suma += i;
        }
    }

    public void setPas(int pas) {
        this.pas = pas;
    }

    public int getSuma() {
        return suma;
    }
}
