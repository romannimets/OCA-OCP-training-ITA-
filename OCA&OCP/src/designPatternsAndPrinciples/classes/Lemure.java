package designPatternsAndPrinciples.classes;

import designPatternsAndPrinciples.interfaces.HaLaCoda;

/**
 * La classe {@code Lemure} estende la classe astratta {@code Primate} e
 * implementa l'interfaccia {@code HaLaCoda}. Rappresenta un lemure, un primate
 * con la caratteristica di possedere una coda a strisce.
 * 
 * La classe fornisce un attributo di istanza {@code age} per rappresentare
 * l'età del lemure, e un metodo di accesso {@code laCodaEAStrisce()} che
 * indica se la coda del lemure è a strisce. Inoltre, sovrascrive il metodo
 * {@code toString()} per fornire una rappresentazione testuale dell'oggetto
 * lemure.
 */
public class Lemure extends Primate implements HaLaCoda {
    /** L'età del lemure. */
    public int age = 10;

    /**
     * Metodo che restituisce {@code true} indicando che la coda del lemure è a strisce.
     * 
     * @return {@code true} se la coda del lemure è a strisce, altrimenti {@code false}.
     */
    @Override
    public boolean laCodaEAStrisce() {
        return true;
    }

    /**
     * Rappresentazione testuale dell'oggetto lemure.
     * 
     * @return Una stringa che descrive il lemure, inclusa la sua età.
     */
    @Override
    public String toString() {
        return "Sono un lemure! [age=" + age + "]";
    }
}
