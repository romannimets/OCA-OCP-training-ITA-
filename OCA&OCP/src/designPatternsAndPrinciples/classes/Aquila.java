package designPatternsAndPrinciples.classes;

import designPatternsAndPrinciples.interfaces.Volo;

/**
 * La classe {@code Aquila} rappresenta un'implementazione specifica di
 * un'istanza di animale, in particolare di un'ala volante. Estende la classe
 * astratta {@link Animale} e implementa l'interfaccia {@link Volo}.
 * 
 * <p>
 * L'{@code Aquila} è un esempio di come una classe possa estendere
 * un'implementazione di base, fornendo dettagli specifici sull'animale e
 * implementando funzionalità di volo.
 * </p>
 * 
 * <p>
 * Il metodo {@code getAperturaAlare()} è stato sovrascritto dall'interfaccia
 * {@code Volo}, fornendo l'apertura alare specifica dell'aquila.
 * </p>
 * 
 * <p>
 * La classe contiene anche un metodo aggiuntivo {@code atterra()}, che
 * rappresenta il processo di atterraggio dell'aquila in picchiata.
 * </p>
 * 
 * <p>
 * Il metodo {@code toString()} è stato sovrascritto per fornire una
 * rappresentazione testuale dell'oggetto {@code Aquila}.
 * </p>
 * 
 * @see Animale
 * @see Volo
 */
public class Aquila extends Animale implements Volo {

	/**
	 * Restituisce l'apertura alare specifica dell'aquila.
	 * 
	 * @return L'apertura alare dell'aquila in centimetri.
	 * @throws Exception Se si verifica un errore durante il recupero dell'apertura
	 *                   alare.
	 */
	@Override
	public int getAperturaAlare() throws Exception {
		return 15;
	}

	/**
	 * Simula l'atterraggio dell'aquila in picchiata.
	 */
	public void atterra() {
		System.out.println("L'aquila sta atterrando fortissimo in picchiata.");
	}

	/**
	 * Restituisce una rappresentazione testuale dell'oggetto {@code Aquila}.
	 * 
	 * @return Una stringa che rappresenta l'aquila.
	 */
	@Override
	public String toString() {
		return "Aquila";
	}
}
