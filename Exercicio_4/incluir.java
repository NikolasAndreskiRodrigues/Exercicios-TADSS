import java.util.List;
import java.util.Random;

public class incluir implements Runnable {
    private final List<Short> numero;
    private final Short valor;

    public incluir(List<Short> numero) {
        this.numero = numero;
        this.valor = null;
    }

    public incluir(List<Short> numero, Short valor) {
        this.numero = numero;
        this.valor = valor;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            synchronized (numero) {
                if (valor != null) {
                    numero.add(valor);
                } else {
                    numero.add((short) r.nextInt(10000));
                }
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
