package genericsAndCollections.interfaces;

/**
 * L'interfaccia Shippable definisce il contratto per gli oggetti che possono essere spediti.
 *
 * @param <T> Il tipo di oggetto che può essere spedito.
 */
public interface Shippable<T> {

    /**
     * Metodo che rappresenta l'azione di spedire un oggetto.
     *
     * @param t L'oggetto da spedire.
     */
    void ship(T t);
}
