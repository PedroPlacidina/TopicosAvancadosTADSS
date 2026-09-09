import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class Includer implements Runnable {
    private List<Integer> list1;
    private List<Integer> list2;

    public Includer(List<Integer> list1, List<Integer> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (!Thread.currentThread().isInterrupted()) {
            synchronized (list1) {
                synchronized (list2) {
                    this.list1.add(random.nextInt(1000));
                    this.list2.add(random.nextInt(1000));
                }
            }
        }

    }
}
