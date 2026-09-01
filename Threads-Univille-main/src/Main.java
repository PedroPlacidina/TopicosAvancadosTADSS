import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Object monitor = new Object();
    public static void main(String[] args) {
        List<Integer> numeros1 = new ArrayList<>();
        List<Integer> numeros2 = new ArrayList<>();

        Thread.ofPlatform().start(new Includer(numeros1, numeros2));
        Thread.ofPlatform().start(new Includer(numeros1, numeros2));
        Thread.ofPlatform().start(new Remover(numeros1, numeros2));
        Thread.ofPlatform().start(new Printer(numeros2));

    }
}