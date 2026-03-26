import java.util.List;

public class remover implements Runnable {
    private final List<Short> numero;

    public remover(List<Short> numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (numero) {
                if (!numero.isEmpty()) {
                    numero.remove(0);
                }
            }

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

