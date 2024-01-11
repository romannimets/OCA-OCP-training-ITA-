package designPatternsAndPrinciples.interfaces;

/**
 * L'interfaccia {@code HaLaCoda} definisce il comportamento associato agli
 * animali che possiedono una coda. Il suo unico metodo,
 * {@code laCodaEAStrisce()}, rappresenta l'azione di verificare se la coda
 * dell'animale è a strisce.
 * 
 * Le classi che implementano questa interfaccia devono fornire una logica
 * specifica per la verifica della caratteristica della coda, garantendo la
 * coerenza con il contesto degli animali che la posseggono.
 * 
 * Questa interfaccia è progettata per essere utilizzata all'interno di un
 * contesto in cui la presenza di una coda a strisce è rilevante, come ad
 * esempio nella classe {@code Lemure}.
 */
public interface HaLaCoda {
	/**
	 * Metodo astratto che verrà implementato per definire l'azione di verificare se
	 * la coda dell'animale è a strisce.
	 * 
	 * @return {@code true} se la coda dell'animale è a strisce, altrimenti
	 *         {@code false}.
	 */
	boolean laCodaEAStrisce();
}
