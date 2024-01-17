package designPatternsAndPrinciples.classes;

/**
 * La classe {@code Mangime} rappresenta un tipo specifico di cibo, estendendo la classe astratta {@link Cibo}.
 * Questa classe fa parte del pattern Factory, fornendo un'implementazione concreta per la creazione di oggetti
 * del tipo {@code Cibo} specifico per il mangime.
 * 
 * <p>Il costruttore di {@code Mangime} richiama il costruttore della classe base ({@code Cibo}) inizializzando la
 * quantità di mangime.</p>
 * 
 * <p>Il metodo {@code mangiato()} è stato implementato per definire il comportamento quando il mangime viene mangiato.
 * In questo caso, viene stampato un messaggio che indica la quantità di mangime consumata.</p>
 * 
 * @see Cibo
 */
public class Mangime extends Cibo {

    /**
     * Costruttore che inizializza la quantità di mangime.
     * 
     * @param quantita La quantità di mangime.
     */
    public Mangime(int quantita) {
        super(quantita);
    }

    /**
     * Implementa il metodo astratto {@code mangiato()}, stampando un messaggio che indica la quantità di mangime consumata.
     */
    @Override
    public void mangiato() {
        System.out.println("MANGIME mangiato: " + getQuantita());
    }
}
