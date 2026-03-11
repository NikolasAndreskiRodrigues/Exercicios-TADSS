package Exercicio_1;

import java.time.LocalTime;

class MinhaThread extends Thread {

    public MinhaThread(String nome) {
        super(nome);
    }

    @Override
    public void run() {
        LocalTime horaAtual = LocalTime.now();
        System.out.println("Thread: " + getName() + " | Hora: " + horaAtual);
    }
}

public class Exercicio_1 {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            MinhaThread t = new MinhaThread("Thread-" + i);
            t.start();
        }
    }
}