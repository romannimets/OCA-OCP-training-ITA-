package designPatternsAndPrinciples.classes;

import designPatternsAndPrinciples.interfaces.Scattare;

/**
 * La classe Tigre rappresenta un felino in grado di eseguire scatti velocissimi,
 * implementando l'interfaccia Scattare.
 */
public class Tigre implements Scattare {

    /**
     * Metodo che rappresenta l'azione di uno scatto veloce della tigre, mentre insegue un altro animale.
     *
     * @param animale L'animale che la tigre sta inseguendo.
     */
    public void scatta(Animale animale) {
        System.out.println("L'animale sta facendo uno scatto velocissimo! Sta inseguendo " + animale.toString());
    }

    /**
     * Metodo che restituisce una rappresentazione testuale della tigre.
     *
     * @return Una stringa rappresentante la tigre.
     */
    @Override
    public String toString() {
        return "Tigre";
    }
}
