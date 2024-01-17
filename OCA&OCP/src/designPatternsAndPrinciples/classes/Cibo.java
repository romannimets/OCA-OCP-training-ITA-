package designPatternsAndPrinciples.classes;

/**
 * La classe astratta {@code Cibo} rappresenta un tipo generico di cibo in un zoo. Possiede una proprietà "quantita"
 * per indicare la quantità di cibo disponibile. Questa classe è progettata secondo il pattern Factory, fornendo
 * un metodo astratto {@code mangiato()} che sarà implementato dalle sottoclassi concrete per definire il comportamento
 * specifico quando il cibo viene consumato.
 */
public abstract class Cibo {
    private int quantita;

    /**
     * Costruttore che inizializza la quantità di cibo.
     * 
     * @param quantita La quantità di cibo disponibile.
     */
    public Cibo(int quantita) {
        this.quantita = quantita;
    }

    /**
     * Metodo getter per ottenere la quantità di cibo disponibile.
     * 
     * @return La quantità di cibo disponibile.
     */
    public int getQuantita() {
        return quantita;
    }

    /**
     * Metodo astratto che rappresenta l'azione di consumare il cibo. Sarà implementato dalle sottoclassi concrete.
     */
    public abstract void mangiato();
}
