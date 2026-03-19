import java.util.List;

public class imprimir implements Runnable {
    private final List<Short> numero;

    public imprimir(List<Short> numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        synchronized (numero) {
            System.out.println("Valores na lista: " + numero);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

