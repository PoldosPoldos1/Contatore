package it.barraco.thread;
import java.util.Random;

public class Lavoratore implements Runnable {
    private final Contatore contatore;
    private final String nome;
    private final Random random;

    public Lavoratore(Contatore contatore, String nome) {
        this.contatore = contatore;
        this.nome = nome;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            boolean incrementato = contatore.incrementa(nome);

            // Se il contatore è arrivato al massimo, il thread termina
            if (!incrementato) {
                break;
            }

            try {
                // Pausa casuale tra 100 e 500 millisecondi
                int pausa = random.nextInt(401) + 100;
                Thread.sleep(pausa);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
