package designPatternsAndPrinciples.classes;

/**
 * La classe {@code Pesce} rappresenta un tipo specifico di cibo, estendendo la classe astratta {@link Cibo}.
 * Questa classe fa parte del pattern Factory, fornendo un'implementazione concreta per la creazione di oggetti
 * del tipo {@code Cibo} specifico per il pesce.
 * 
 * <p>Il costruttore di {@code Pesce} richiama il costruttore della classe base ({@code Cibo}) inizializzando la
 * quantità di pesce.</p>
 * 
 * <p>Il metodo {@code mangiato()} è stato implementato per definire il comportamento quando il pesce viene mangiato.
 * In questo caso, viene stampato un messaggio che indica la quantità di pesce consumata.</p>
 * 
 * @see Cibo
 */
public class Pesce extends Cibo {

    /**
     * Costruttore che inizializza la quantità di pesce.
     * 
     * @param quantita La quantità di pesce.
     */
    public Pesce(int quantita) {
        super(quantita);
    }

    /**
     * Implementa il metodo astratto {@code mangiato()}, stampando un messaggio che indica la quantità di pesce consumata.
     */
    @Override
    public void mangiato() {
        System.out.println("PESCE mangiato: " + getQuantita());
    }
}
