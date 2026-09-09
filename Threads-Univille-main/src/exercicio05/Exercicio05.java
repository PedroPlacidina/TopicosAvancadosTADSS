package exercicio05;

import java.util.*;

public class Exercicio05 {

    public static void main(String[] args) throws Exception {
         Random random = new Random();
        Map<Integer, Conta> contas = new HashMap<>();
        Banco firmeza = new Banco();
        for (int i = 1; i <= 100; i++) {
            firmeza.addConta(i, 1000.00);
        }
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                while (true) {
                    firmeza.transfere(random.nextInt(100) + 1,
                            random.nextInt(100) + 1,
                            random.nextDouble(2500));
                }
            }).start();
        }

        long ini = System.currentTimeMillis();
        do {
            Thread.sleep(5000);
            System.out.printf("Saldo total: %,1.2f%n", firmeza.getSaldoTotal());
            System.out.printf("Transações: %,d%n", firmeza.getTransacoes());
        } while (System.currentTimeMillis() - ini < 30000);

    }
}
