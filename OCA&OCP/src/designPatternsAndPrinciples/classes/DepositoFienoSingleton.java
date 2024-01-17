package designPatternsAndPrinciples.classes;

/**
 * Implementazione del Singleton DepositoFieno che gestisce la quantità di fieno disponibile.
 * 
 * Nota: I metodi aggiungiFieno(), rimuoviFieno() e getQuantitaFieno() sono sincronizzati per
 * prevenire l'esecuzione simultanea di due processi sullo stesso metodo nello stesso momento.
 * Discuteremo questi concetti in dettaglio nel capitolo "Concurrency".
 * 
 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html">Metodi sincronizzati (Oracle)</a>
 */
public class DepositoFienoSingleton {

    // Variabile per tenere traccia della quantità di fieno
    private int quantita = 0;

    // Costruttore privato per evitare l'istanziazione diretta
    private DepositoFienoSingleton() {
    }

    // Singleton instance creata come variabile statica final
    private static final DepositoFienoSingleton instance = new DepositoFienoSingleton();

    /**
     * Ottiene l'istanza del Singleton DepositoFieno.
     *
     * @return L'istanza del Singleton DepositoFieno.
     */
    public static DepositoFienoSingleton getInstance() {
        return instance;
    }

    /**
     * Aggiunge una quantità specificata di fieno al deposito.
     *
     * @param quantitaAggiunta La quantità di fieno da aggiungere.
     */
    public synchronized void aggiungiFieno(int quantitaAggiunta) {
        quantita += quantitaAggiunta;
    }

    /**
     * Rimuove una quantità specificata di fieno dal deposito.
     *
     * @param quantitaRimossa La quantità di fieno da rimuovere.
     * @return True se la quantità di fieno è sufficiente e la rimozione è avvenuta con successo, False altrimenti.
     */
    public synchronized boolean rimuoviFieno(int quantitaRimossa) {
        if (quantita < quantitaRimossa) {
            return false;
        }
        quantita -= quantitaRimossa;
        return true;
    }

    /**
     * Ottiene la quantità attuale di fieno nel deposito.
     *
     * @return La quantità attuale di fieno nel deposito.
     */
    public synchronized int getQuantitaFieno() {
        return quantita;
    }
}
