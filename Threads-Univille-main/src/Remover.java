import java.util.List;

public class Remover implements Runnable {

    private final List<Integer> numeros1;
    private final List<Integer> numeros2;

    public Remover(List<Integer> numeros1, List<Integer> numeros2) {
        this.numeros1 = numeros1;
        this.numeros2 = numeros2;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            synchronized (numeros1) {
                if (!numeros1.isEmpty()) {
                    numeros1.removeFirst();
                }
            }

            synchronized (numeros2) {
                if (!numeros2.isEmpty()) {
                    numeros2.removeFirst();
                }
            }
        }
    }
}