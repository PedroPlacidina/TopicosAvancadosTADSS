package exercicio07;

import java.util.LinkedList;
import java.util.Queue;

public class Escorredor {
    private final Queue<Integer> pratos = new LinkedList<>();
    private final int capacidade;
 
    public Escorredor(int capacidade) {
        this.capacidade = capacidade;
    }

    public synchronized void colocarPrato(int numeroPrato) throws InterruptedException {
        while (pratos.size() == capacidade) {
            wait(); 
        }
        pratos.add(numeroPrato);
        System.out.println("[Escorredor] prato " + numeroPrato + " colocado (" + pratos.size() + "/" + capacidade + ")");
        notifyAll();
    }
 
   
    public synchronized int retirarPrato() throws InterruptedException {
        while (pratos.isEmpty()) {
            wait(); 
        }
        int prato = pratos.poll();
        notifyAll(); 
        return prato;
    }
}
