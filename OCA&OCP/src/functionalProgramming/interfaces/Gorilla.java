package functionalProgramming.interfaces;

/**
 * L'interfaccia Gorilla rappresenta il comportamento associato alle azioni
 * eseguite da un gorilla all'interno della comunità. Il suo unico metodo,
 * {@code move()}, definisce l'azione che il gorilla compie durante il gioco. Le
 * classi che implementano questa interfaccia devono fornire una logica
 * specifica per l'azione del gorilla, garantendo la coerenza con il contesto
 * della comunità di gorilla rappresentato dalla classe
 * {@code FamigliaDiGorilla}.
 */
public interface Gorilla {
	/**
	 * Questo metodo è progettato per essere utilizzato all'interno del contesto del
	 * modello di programmazione funzionale della comunità di gorilla, consentendo
	 * una dichiarazione chiara e concisa delle azioni attraverso l'utilizzo di
	 * espressioni lambda e il concetto di "effettivamente finale".
	 * 
	 * @return Una stringa che rappresenta il movimento del gorilla durante il
	 * gioco.
	 */
	String move();
}
