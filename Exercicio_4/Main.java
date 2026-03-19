import java.util.ArrayList;

public class Main {

public static void main(String[] args) throws InterruptedException {
    ArrayList<Short> numero = new ArrayList<Short>();
    Thread.ofPlatform().start(new incluir(numero));
    Thread.ofPlatform().start(new incluir(numero)); 
    Thread.ofPlatform().start(new remover(numero));  
    Thread.ofPlatform().start(new imprimir(numero));  
}

}