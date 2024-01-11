package designPatternsAndPrinciples.interfaces;

import designPatternsAndPrinciples.classes.Animale2;

/**
 * L'interfaccia funzionale {@code CheckCaratteristica} definisce un unico metodo
 * astratto, {@code test}, che verrà implementato dalle classi che intendono
 * fornire una logica specifica per la verifica di una caratteristica su un oggetto
 * di tipo {@code Animale2}.
 * 
 * Questa interfaccia è contrassegnata con l'annotazione {@code @FunctionalInterface},
 * indicando che è destinata a essere utilizzata come interfaccia funzionale, ovvero
 * un'interfaccia con un solo metodo astratto. Questa annotazione facilita l'utilizzo
 * di espressioni lambda e metodi di riferimento nel contesto di programmazione
 * funzionale.
 * 
 * @see Animale2
 */
@FunctionalInterface
public interface CheckCaratteristica {
    /**
     * Metodo astratto che verrà implementato per definire la logica di verifica
     * di una caratteristica su un oggetto di tipo {@code Animale2}.
     * 
     * @param a L'oggetto di tipo {@code Animale2} su cui verificare la
     *          caratteristica.
     * @return {@code true} se l'oggetto possiede la caratteristica verificata,
     *         altrimenti {@code false}.
     */
    boolean test(Animale2 a);
}

