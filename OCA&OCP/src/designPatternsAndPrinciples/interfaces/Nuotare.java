package designPatternsAndPrinciples.interfaces;

/**
 * L'interfaccia Nuotare definisce il comportamento di un oggetto che può nuotare.
 * Gli oggetti che implementano questa interfaccia devono fornire un'implementazione
 * del metodo {@code nuota()} che rappresenta l'azione di nuotare.
 */
public interface Nuotare {

    /**
     * Metodo astratto che rappresenta l'azione di nuotare.
     */
    void nuota();
}
