package designPatternsAndPrinciples.interfaces;

/**
 * L'interfaccia Volo definisce il comportamento di un oggetto che può volare.
 */
public interface Volo {

    /**
     * Restituisce l'apertura alare dell'animale che sta volando.
     *
     * @return L'apertura alare dell'animale.
     * @throws Exception Se si verifica un'eccezione durante il recupero dell'apertura alare.
     *                   Le classi che implementano questa interfaccia devono gestire o dichiarare questa eccezione.
     */
    public int getAperturaAlare() throws Exception;

    /**
     * Costante statica che rappresenta la velocità massima di volo disponibile in tutta l'applicazione.
     */
    public static final int MAX_SPEED = 100;

    /**
     * Metodo di default che rappresenta l'azione di atterraggio.
     * Fornisce un'implementazione di default nel caso in cui una classe che implementa l'interfaccia non fornisca la propria implementazione.
     */
    public default void atterra() {
        System.out.println("L'animale sta atterrando");
    }

    /**
     * Calcola la velocità di volo in base allo spazio percorso e al tempo impiegato.
     *
     * @param spazio La distanza percorsa durante il volo.
     * @param tempo Il tempo impiegato per percorrere la distanza.
     * @return La velocità di volo calcolata.
     */
    public static double calcolaVelocita(float spazio, double tempo) {
        return spazio / tempo;
    }
}
