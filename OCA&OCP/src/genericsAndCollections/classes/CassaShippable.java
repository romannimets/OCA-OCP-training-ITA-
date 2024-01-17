package genericsAndCollections.classes;

import genericsAndCollections.interfaces.Shippable;

/**
 * La classe CassaShippable rappresenta un'implementazione dell'interfaccia Shippable senza l'uso di generics.
 * Questa classe può essere utilizzata per spedire oggetti di tipo Object.
 */
public class CassaShippable implements Shippable {

    /**
     * Implementazione del metodo ship dell'interfaccia Shippable.
     *
     * @param t L'oggetto da spedire.
     */
    @Override
    public void ship(Object t) {
        System.out.println(t + " è stato spedito");
    }
}
