package designPatternsAndPrinciples.interfaces;

/**
 * L'interfaccia Saltare definisce il comportamento di un oggetto che può eseguire salti.
 * Gli oggetti che implementano questa interfaccia devono fornire un'implementazione
 * del metodo {@code salta()} che rappresenta l'azione di saltare.
 */
public interface Saltare {

    /**
     * Metodo astratto che rappresenta l'azione di saltare.
     */
    void salta();
}
