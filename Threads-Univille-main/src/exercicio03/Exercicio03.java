package exercicio03;

import java.util.Random;

public class Exercicio03 {
    public static void main(String[] args) throws Exception {
        short[] numeros = new short[1_000_000_000];
        Random r = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (short) r.nextInt(Short.MAX_VALUE);
        }

        // parte I
        long ini = System.currentTimeMillis();
        long total = 0;
        for (short numero:numeros) {
            total += numero;
        }
        long tempo = System.currentTimeMillis() - ini;
        System.out.printf("Total: %,d%n", total);
        System.out.printf("Tempo: %,d%n%n", tempo);

        // parte II
        ini = System.currentTimeMillis();
        total = 0;
        int qtThreads = 10;
        int slice = numeros.length / qtThreads;
        Minion[] minions = new Minion[qtThreads];
        Thread[] threads = new Thread[qtThreads];
        int inicio = 0;
        for (int i = 0; i < qtThreads; i++) {
            minions[i] = new Minion(numeros, inicio, slice);
            threads[i] = Thread.ofPlatform().start(minions[i]);
            inicio += slice;
        }
        for (int i = 0; i < qtThreads; i++) {
            threads[i].join();
            total += minions[i].getTotal();
        }
        long tempo2 = System.currentTimeMillis() - ini;
        double speedUp = (double) tempo / tempo2;
        double eficiencia = speedUp / qtThreads * 100;
        System.out.printf("%d Threads%n", qtThreads);
        System.out.printf("Total: %,d%n", total);
        System.out.printf("Tempo: %,d%n", tempo2);
        System.out.printf("SpeedUp: %.2f%n", speedUp);
        System.out.printf("Eficiencia: %.2f%%%n%n", eficiencia);

        // parte III
        ini = System.currentTimeMillis();
        total = 0;
        qtThreads = 100;
        slice = numeros.length / qtThreads;
        minions = new Minion[qtThreads];
        threads = new Thread[qtThreads];
        inicio = 0;
        for (int i = 0; i < qtThreads; i++) {
            minions[i] = new Minion(numeros, inicio, slice);
            threads[i] = Thread.ofPlatform().start(minions[i]);
            inicio += slice;
        }
        for (int i = 0; i < qtThreads; i++) {
            threads[i].join();
            total += minions[i].getTotal();
        }
        tempo2 = System.currentTimeMillis() - ini;
        speedUp = (double) tempo / tempo2;
        eficiencia = speedUp / qtThreads * 100;
        System.out.printf("%d Threads%n", qtThreads);
        System.out.printf("Total: %,d%n", total);
        System.out.printf("Tempo: %,d%n", tempo2);
        System.out.printf("SpeedUp: %.2f%n", speedUp);
        System.out.printf("Eficiencia: %.2f%%%n%n", eficiencia);

        // parte IV
        ini = System.currentTimeMillis();
        total = 0;
        qtThreads = 10;
        slice = numeros.length / qtThreads;
        minions = new Minion[qtThreads];
        threads = new Thread[qtThreads];
        inicio = 0;
        for (int i = 0; i < qtThreads; i++) {
            minions[i] = new Minion(numeros, inicio, slice);
            threads[i] = Thread.ofVirtual().start(minions[i]);
            inicio += slice;
        }
        for (int i = 0; i < qtThreads; i++) {
            threads[i].join();
            total += minions[i].getTotal();
        }
        tempo2 = System.currentTimeMillis() - ini;
        speedUp = (double) tempo / tempo2;
        eficiencia = speedUp / qtThreads * 100;
        System.out.printf("%d Threads Virtuais%n", qtThreads);
        System.out.printf("Total: %,d%n", total);
        System.out.printf("Tempo: %,d%n", tempo2);
        System.out.printf("SpeedUp: %.2f%n", speedUp);
        System.out.printf("Eficiencia: %.2f%%%n%n", eficiencia);

        // parte V
        ini = System.currentTimeMillis();
        total = 0;
        qtThreads = 100;
        slice = numeros.length / qtThreads;
        minions = new Minion[qtThreads];
        threads = new Thread[qtThreads];
        inicio = 0;
        for (int i = 0; i < qtThreads; i++) {
            minions[i] = new Minion(numeros, inicio, slice);
            threads[i] = Thread.ofVirtual().start(minions[i]);
            inicio += slice;
        }
        for (int i = 0; i < qtThreads; i++) {
            threads[i].join();
            total += minions[i].getTotal();
        }
        tempo2 = System.currentTimeMillis() - ini;
        speedUp = (double) tempo / tempo2;
        eficiencia = speedUp / qtThreads * 100;
        System.out.printf("%d Threads Virtuais%n", qtThreads);
        System.out.printf("Total: %,d%n", total);
        System.out.printf("Tempo: %,d%n", tempo2);
        System.out.printf("SpeedUp: %.2f%n", speedUp);
        System.out.printf("Eficiencia: %.2f%%%n%n", eficiencia);

                // parte V
        ini = System.currentTimeMillis();
        total = 0;
        qtThreads = Runtime.getRuntime().availableProcessors();
        slice = numeros.length / qtThreads;
        minions = new Minion[qtThreads];
        threads = new Thread[qtThreads];
        inicio = 0;
        for (int i = 0; i < qtThreads; i++) {
            minions[i] = new Minion(numeros, inicio, slice);
            threads[i] = Thread.ofVirtual().start(minions[i]);
            inicio += slice;
        }
        for (int i = 0; i < qtThreads; i++) {
            threads[i].join();
            total += minions[i].getTotal();
        }
        tempo2 = System.currentTimeMillis() - ini;
        speedUp = (double) tempo / tempo2;
        eficiencia = speedUp / qtThreads * 100;
        System.out.printf("%d Threads Virtuais%n", qtThreads);
        System.out.printf("Total: %,d%n", total);
        System.out.printf("Tempo: %,d%n", tempo2);
        System.out.printf("SpeedUp: %.2f%n", speedUp);
        System.out.printf("Eficiencia: %.2f%%%n%n", eficiencia);

    }
}
