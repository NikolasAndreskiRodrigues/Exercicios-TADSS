import java.util.SplittableRandom;

public class Exercicio {
    static final int tam = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        int[] numero = aleatorio();
        
        executarSequencial(numero);

        executarConcorrente(numero, 10, false);
        executarConcorrente(numero, 100, false);

        executarConcorrente(numero, 10, true);
        executarConcorrente(numero, 100, true);

    }   

    static int[] aleatorio() {
            int[] tamanho = new int[tam];
            SplittableRandom aleatorio = new SplittableRandom();
            for (int i = 0; i < tamanho.length; i++) {
                tamanho[i] = (int) aleatorio.nextInt(1, Integer.MAX_VALUE);
        }

        return tamanho;
    }

    static void executarSequencial(int[]numero) {
        //Parte 1 -> Somar Sequencialmente
        long tempoinicial =  System.nanoTime();
        long soma_numeros = 0;
        for (int i = 0; i < numero.length; i++) {
            soma_numeros += numero[i];
        }
        long tempofinal = System.nanoTime();
        double tempo = (tempofinal - tempoinicial) / 1_000_000_000.0; 
        System.out.println("Soma total: " + soma_numeros);
        System.out.println("Tempo total em milisegundos: " + tempo);
    }

    static void executarConcorrente(int[] numero, int nThreads, boolean virtual) throws Exception {
        Thread[] threads = new Thread[nThreads];
        Soma[] tarefas = new Soma[nThreads];

        int bloco = numero.length / nThreads;
        int inicio = 0;

        long tempoinicial = System.nanoTime();

        for (int i = 0; i < nThreads; i++) {

            tarefas[i] = new Soma(numero, inicio, bloco);

            if (virtual) {
                threads[i] = Thread.ofVirtual().start(tarefas[i]);
            } else {
                threads[i] = Thread.ofPlatform().start(tarefas[i]);
            }

            inicio += bloco;
        }

        long soma = 0;

        for (int i = 0; i < nThreads; i++) {
            threads[i].join();
            soma += tarefas[i].getSoma();
        }

        long tempofinal = System.nanoTime();
        double tempo = (tempofinal - tempoinicial) / 1_000_000.0;

        String tipo = virtual ? "Virtuais" : "Plataforma";

        System.out.println(nThreads + " Threads " + tipo);
        System.out.println("Soma: " + soma);
        System.out.println("Tempo: " + tempo + " ms\n");
    }
}


