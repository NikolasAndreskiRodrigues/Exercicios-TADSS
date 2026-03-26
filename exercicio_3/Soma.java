public class Soma implements Runnable {

    private int[] numero;
    private int inicio;
    private int tamanho;
    private long soma;

    public Soma(int[] numero, int inicio, int tamanho) {
        this.numero = numero;
        this.inicio = inicio;
        this.tamanho = tamanho;
    }

    @Override
    public void run() {

        int fim = inicio + tamanho;

        for (int i = inicio; i < fim && i < numero.length; i++) {
            soma += numero[i];
        }
    }

    public long getSoma() {
        return soma;
    }
}
