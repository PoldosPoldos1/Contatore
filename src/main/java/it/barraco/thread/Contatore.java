package it.barraco.thread;

public class Contatore {
    private int valore;
    private final int valoreMassimo;

    public Contatore(int valoreMassimo) {
        this.valore = 0;
        this.valoreMassimo = valoreMassimo;
    }

    /*
     * synchronized impedisce a due thread di eseguire
     * contemporaneamente questo metodo sullo stesso oggetto.
     */
    public synchronized boolean incrementa(String nomeThread) {
        if (valore < valoreMassimo) {
            valore++;

            System.out.println(
                nomeThread + " ha incrementato il contatore a: " + valore
            );

            return true;
        }

        return false;
    }
}

