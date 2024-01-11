package functionalProgramming.classes;

import functionalProgramming.interfaces.Gorilla;

/**
 * La classe FamigliaDiGorilla (v.impl) rappresenta una comunità di gorilla e il
 * modo in cui si divertono. Ogni gorilla può eseguire diverse azioni, come
 * camminare, giocare a cavalcioni o correre. 
 *
 * Questo modello di programmazione funzionale consente una dichiarazione chiara
 * e concisa delle azioni dei gorilla all'interno della comunità, dimostrando
 * l'utilità delle espressioni lambda e il concetto di "effettivamente finale".
 */
public class FamigliaDiGorilla {
    // Variabile di istanza che rappresenta l'azione di camminare
    String andatura = "camminano";

    /**
     * Metodo che rappresenta l'azione di gioco di tutti i gorilla nella famiglia.
     * 
     * @param cucciolo true se c'è un cucciolo, altrimenti false
     */
    public void tuttiGiocano(boolean cucciolo) {
        // Variabile locale che rappresenta l'approccio dei gorilla
        String approccio = "trotterellano";
   
        // approccio = "correre";
        // Se decommentato, cambierebbe l'approccio a "correre", e approccio non sarebbe
        // più "EFFETTIVAMENTE FINALE"

        // Utilizzo di una lambda per accedere a una variabile di istanza
        // (effettivamente finale)
        giocare(() -> "I gorilla " + andatura);
        // Utilizzo di una lambda con operatore ternario per accedere a un parametro di
        // metodo (effettivamente finale)
        giocare(() -> cucciolo ? "C'è un cucciolo! I gorilla giocano a cavalcioni" : "Non ci sono cuccioli... I gorilla corrono lottano e saltano insieme ");
        
        // Utilizzo di una lambda per accedere a una variabile locale effettivamente
        // finale
        giocare(() -> "I gorilla " + approccio);
    }

    /**
     * Metodo che esegue l'azione di gioco del gorilla usando l'interfaccia
     *  Gorilla.
     * 
     * @param g Oggetto Gorilla che rappresenta l'azione del gorilla
     */
    void giocare(Gorilla g) { // v.impl
        // Stampa l'azione del gorilla
        System.out.println(g.move()); 
    }
}
