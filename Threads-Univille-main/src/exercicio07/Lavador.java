package exercicio07;

public class Lavador {
    private final Escorredor escorredor;
    private final int totalPratos;
    private final int numSecadores;
    private static final int PRATO_POISON = -1; // sinal de "acabou"
 
    public Lavador(Escorredor escorredor, int totalPratos, int numSecadores) {
        this.escorredor = escorredor;
        this.totalPratos = totalPratos;
        this.numSecadores = numSecadores;
    }
 
    @Override
    public void run() {
        try {
            for (int i = 1; i <= totalPratos; i++) {
                Thread.sleep(20); // simula o tempo de lavar um prato
                System.out.println("[Lavador] lavou o prato " + i);
                escorredor.colocarPrato(i);
            }
            // Envia um "prato veneno" para cada secador, avisando que não vem mais nada
            for (int i = 0; i < numSecadores; i++) {
                escorredor.colocarPrato(PRATO_POISON);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
