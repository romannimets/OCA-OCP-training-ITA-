package designPatternsAndPrinciples.interfaces;

/**
 * L'interfaccia {@code ViveInMare} definisce il comportamento associato agli
 * animali che vivono nel mare. Il suo unico metodo, {@code emettiSuono()},
 * rappresenta l'azione di emettere un suono tipica degli organismi marini.
 * 
 * Le classi che implementano questa interfaccia devono fornire una logica
 * specifica per l'emissione del suono, garantendo la coerenza con il contesto
 * marino rappresentato dalle classi come {@code Balena} e {@code Delfino}.
 * 
 * Questa interfaccia è progettata per essere utilizzata all'interno di un
 * contesto di studio degli organismi marini, consentendo una dichiarazione chiara
 * delle azioni attraverso l'implementazione del metodo {@code emettiSuono()}.
 */
public interface ViveInMare {
    /**
     * Metodo astratto che verrà implementato per definire l'azione di emettere
     * un suono tipica degli organismi marini.
     */
    void emettiSuono();
}

