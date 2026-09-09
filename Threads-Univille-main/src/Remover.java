import java.util.List;

public class Remover implements Runnable {
    private List<Integer> list;

    public Remover(List<Integer> list) {
        this.list = list;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (list) {
                this.list.removeFirst();
            }
        }
    }
}
