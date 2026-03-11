package Exercicio_2;
class MinhaThread extends Thread { 

    public MinhaThread(String nome) {
        super(nome);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread: " + getName() + " " + i);
        }
    }
}

public class Exercicio_2 {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            MinhaThread t = new MinhaThread("Thread-" + i);
            t.start();
        }
    }
}