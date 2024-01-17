package designPatternsAndPrinciples.classes;

/**
 * La classe {@code Fieno} rappresenta un tipo specifico di cibo, estendendo la classe astratta {@link Cibo}.
 * Questa classe fa parte del pattern Factory, fornendo un'implementazione concreta per la creazione di oggetti
 * del tipo {@code Cibo} specifico per il fieno.
 * 
 * <p>Il costruttore di {@code Fieno} richiama il costruttore della classe base ({@code Cibo}) inizializzando la
 * quantità di fieno.</p>
 * 
 * <p>Il metodo {@code mangiato()} è stato implementato per definire il comportamento quando il fieno viene mangiato.
 * In questo caso, viene stampato un messaggio che indica la quantità di fieno mangiata.</p>
 * 
 * @see Cibo
 */
public class Fieno extends Cibo {

    /**
     * Costruttore che inizializza la quantità di fieno.
     * 
     * @param quantita La quantità di fieno.
     */
    public Fieno(int quantita) {
        super(quantita);
    }

    /**
     * Implementa il metodo astratto {@code mangiato()}, stampando un messaggio che indica la quantità di fieno mangiata.
     */
    @Override
    public void mangiato() {
        System.out.println("FIENO mangiato: " + getQuantita());
    }
}
