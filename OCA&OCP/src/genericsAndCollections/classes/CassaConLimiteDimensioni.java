package genericsAndCollections.classes;

/**
 * La classe CassaConLimiteDimensioni rappresenta una cassa contenente un oggetto di tipo generico,
 * con una dimensione massima specificata da un secondo tipo generico.
 *
 * @param <T> Il tipo di oggetto contenuto nella cassa.
 * @param <U> Il tipo di dimensione massima della cassa.
 */
public class CassaConLimiteDimensioni<T, U> {

    /**
     * Contenuto attuale della cassa.
     */
    private T contenuto;

    /**
     * Dimensione massima della cassa.
     */
    private U limiteDimensioni;

    /**
     * Costruttore della classe CassaConLimiteDimensioni.
     *
     * @param contenuto       Il contenuto iniziale della cassa.
     * @param limiteDimensioni La dimensione massima della cassa.
     */
    public CassaConLimiteDimensioni(T contenuto, U limiteDimensioni) {
        this.contenuto = contenuto;
        this.limiteDimensioni = limiteDimensioni;
    }

    /**
     * Ottiene il contenuto attuale della cassa.
     *
     * @return Il contenuto della cassa.
     */
    public T getContenuto() {
        return contenuto;
    }

    /**
     * Imposta il contenuto della cassa con il nuovo valore specificato.
     *
     * @param contenuto Il nuovo contenuto da impostare nella cassa.
     */
    public void setContenuto(T contenuto) {
        this.contenuto = contenuto;
    }

    /**
     * Ottiene la dimensione massima della cassa.
     *
     * @return La dimensione massima della cassa.
     */
    public U getLimiteDimensioni() {
        return limiteDimensioni;
    }

    /**
     * Imposta la dimensione massima della cassa con il nuovo valore specificato.
     *
     * @param limiteDimensioni La nuova dimensione massima della cassa.
     */
    public void setLimiteDimensioni(U limiteDimensioni) {
        this.limiteDimensioni = limiteDimensioni;
    }
}
