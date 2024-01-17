package designPatternsAndPrinciples.classes;

import designPatternsAndPrinciples.interfaces.Camminare;
import designPatternsAndPrinciples.interfaces.Nuotare;
import designPatternsAndPrinciples.interfaces.Saltare;

/**
 * La classe Rana rappresenta un animale anfibio con capacità di nuotare, saltare e camminare.
 * Estende la classe Animale e implementa le interfacce Saltare, Nuotare e Camminare.
 */
public class Rana extends Animale implements Saltare, Nuotare, Camminare {

    /**
     * Metodo che rappresenta l'azione di nuotare della rana.
     */
    @Override
    public void nuota() {
        System.out.println("La rana sta nuotando");
    }

    /**
     * Metodo che rappresenta l'azione di saltare della rana.
     */
    @Override
    public void salta() {
        System.out.println("La rana salta");
    }

    /**
     * Metodo che restituisce se la rana è un quadrupede.
     *
     * @return true se la rana è un quadrupede, false altrimenti.
     */
    @Override
    public boolean isQuadrupede() {
        return true;
    }

    /**
     * Metodo che restituisce la massima velocità della rana.
     *
     * @return La massima velocità della rana.
     */
    @Override
    public double getMaxVelocita() {
        return 15;
    }

    /**
     * Metodo che restituisce una rappresentazione testuale della rana.
     *
     * @return Una stringa rappresentante la rana.
     */
    @Override
    public String toString() {
        return "Rana";
    }
}
