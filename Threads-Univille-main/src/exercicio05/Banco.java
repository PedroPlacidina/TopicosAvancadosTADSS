package exercicio05;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Banco implements Runnable {
    private Double saldo;
    private Map<Integer, Conta> contas;
    private AtomicInteger transacoes;

    @Override
    public void run() {
    }


    public Banco() {
        contas = new LinkedHashMap<>();
        transacoes = new AtomicInteger();
    }

    public int getTransacoes() {
        return transacoes.get();
    }

    public void addConta(int id, double saldoInicial) {
        contas.put(id, new Conta(saldoInicial, id));
    }

    public synchronized double getSaldoTotal() {
        double saldo = 0;
        for (Conta conta : contas.values()) {
            conta.lock();
        }
        for (Conta conta : contas.values()) {
            saldo += conta.getSaldo();
        }
        for (Conta conta : contas.values()) {
            conta.unlock();
        }
        return saldo;
    }

    public synchronized  void transfere(int contaDebito, int contaCredito, double valor) {
        Conta ContaD = contas.get(contaDebito);
        Conta ContaC = contas.get(contaCredito);

        Conta o1;
        Conta o2;
        if (contaDebito < contaCredito) {
            o1 = ContaD;
            o2 = ContaC;
        } else {
            o2 = ContaD;
            o1 = ContaC;
        }

        o1.lock();
        o2.lock();
        ContaC.deposita(valor);
        ContaD.retira(valor);
        o1.unlock();
        o2.unlock();

        transacoes.incrementAndGet();
    }
}
