package genericsAndCollections.classes;

import genericsAndCollections.interfaces.Shippable;

/**
 * La classe CassaShippableAbstract rappresenta un'implementazione parametrica dell'interfaccia Shippable.
 *
 * @param <U> Il tipo parametrico per la cassa shippable.
 */
public class CassaShippableAbstract<U> implements Shippable<U> {

    /**
     * Implementazione del metodo ship dell'interfaccia Shippable.
     *
     * @param t L'oggetto di tipo U da spedire.
     */
    @Override
    public void ship(U t) {
        System.out.println(t + " è stato spedito");
    }
}
