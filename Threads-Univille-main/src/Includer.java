import java.util.List;
import java.util.Random;

public class Includer implements Runnable {

    private final List<Integer> numeros1;
    private final List<Integer> numeros2;

    public Includer(List<Integer> numeros1, List<Integer> numeros2) {
        this.numeros1 = numeros1;
        this.numeros2 = numeros2;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (!Thread.currentThread().isInterrupted()) {
            synchronized (numeros1) {
                synchronized (numeros2) {
                    numeros1.add(random.nextInt(1000));
                    numeros2.add(random.nextInt(1000));
                }
            }
        }
    }
}
