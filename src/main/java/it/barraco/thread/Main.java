package it.barraco.thread;

public class Main {
    public static void main(String[] args) {
        // Un solo contatore condiviso dai due lavoratori
        Contatore contatore = new Contatore(10);

        Lavoratore lavoratore1 =
                new Lavoratore(contatore, "Thread-1");

        Lavoratore lavoratore2 =
                new Lavoratore(contatore, "Thread-2");

        Thread thread1 = new Thread(lavoratore1);
        Thread thread2 = new Thread(lavoratore2);

        thread1.start();
        thread2.start();

        try {
            // Il main aspetta che entrambi i thread terminino
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Raggiunto il valore massimo del contatore!");
    }
}
