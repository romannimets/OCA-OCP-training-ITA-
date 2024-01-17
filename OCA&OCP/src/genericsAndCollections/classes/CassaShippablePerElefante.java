package genericsAndCollections.classes;

import genericsAndCollections.interfaces.Shippable;

/**
 * La classe CassaShippablePerElefante rappresenta un'implementazione specifica dell'interfaccia Shippable per elefanti.
 */
public class CassaShippablePerElefante implements Shippable<Elefante> {

    /**
     * Implementazione del metodo ship dell'interfaccia Shippable.
     *
     * @param t L'elefante da spedire.
     */
    @Override
    public void ship(Elefante t) {
        System.out.println(t + " è stato spedito");
    }
}
