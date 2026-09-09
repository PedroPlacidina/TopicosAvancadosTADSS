package exercicio03;

public class Minion implements Runnable {
    private short[] numeros;
    private int ini;
    private int size;
    private long total;

    public Minion(short[] numeros, int ini, int size) {
        this.numeros = numeros;
        this.ini = ini;
        this.size = size;
    }

    @Override
    public void run() {
        for (int i = ini; i < ini + size; i++) {
            total += numeros[i];
        }
    }

    public long getTotal() {
        return total;
    }
}
