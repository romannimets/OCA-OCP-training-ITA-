package designPatternsAndPrinciples.classes;

import designPatternsAndPrinciples.interfaces.ViveInMare;

/**
 * La classe {@code Delfino} rappresenta un tipo di animale marino che implementa
 * l'interfaccia {@code ViveInMare}. Fornisce un'implementazione del metodo
 * {@code emettiSuono()} che rappresenta il suono emesso da un delfino durante
 * le sue attività.
 */
public class Delfino implements ViveInMare {

    /**
     * Implementazione del metodo che rappresenta il suono emesso da un delfino.
     */
    @Override
    public void emettiSuono() {
        System.out.println("Il delfino fischia");
    }
}
