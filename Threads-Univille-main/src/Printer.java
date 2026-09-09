import java.util.List;

public class Printer implements Runnable {
    private final List<Integer> list;

    public Printer(List<Integer> list) {
        this.list = list;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (list) {
                System.out.println(this.list);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
