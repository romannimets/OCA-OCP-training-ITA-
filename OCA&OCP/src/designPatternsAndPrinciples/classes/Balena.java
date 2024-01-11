package designPatternsAndPrinciples.classes;

import designPatternsAndPrinciples.interfaces.ViveInMare;

/**
 * La classe {@code Balena} rappresenta un tipo di animale marino che implementa
 * l'interfaccia {@code ViveInMare}. Fornisce un'implementazione del metodo
 * {@code emettiSuono()} che rappresenta il suono emesso da una balena durante
 * le sue attività.
 */
public class Balena implements ViveInMare {

    /**
     * Implementazione del metodo che rappresenta il suono emesso da una balena.
     */
    @Override
    public void emettiSuono() {
        System.out.println("La balena canta");
    }
}
