package functionalProgramming;

import functionalProgramming.classes.FamigliaDiGorilla;
import utils.Colors;

public class RUN_FunctionalProgramming {

	public static void main(String[] args) {
		// FUNCTIONAL PROGRAMMING
		System.out.println("	" + Colors.BLUE_BACKGROUND_BRIGHT.get() + Colors.BLACK_UNDERLINED.get()
				+ Colors.BLACK_BOLD.get() + "FUNCTIONAL PROGRAMMING" + Colors.RESET.get());
		// Using Variables in Lambdas
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Utilizzo delle variabili nelle Lambda" + Colors.RESET.get());

		/*
		 * Le espressioni lambda seguono le stesse regole di accesso delle classi
		 * interne(inner classes):
		 *
		 * Le espressioni lambda possono accedere a variabili statiche, variabili di
		 * istanza, parametri di metodo effettivamente finali e variabili locali
		 * effettivamente finali.
		 * 
		 * Concetto di "effettivamente finale": Se si può aggiungere il modificatore
		 * final a una variabile locale senza che ci siano errori, essa può essere
		 * considerata "effettivamente finale".
		 */

		// Creazione di un'istanza della classe FamigliaDiGorilla
		FamigliaDiGorilla famiglia = new FamigliaDiGorilla(); // v.impl
		
		// Chiamate ai metodi della classe FamigliaDiGorilla
		famiglia.tuttiGiocano(true);
		System.out.println("\nNon ci sono cuccioli...\n ");
		famiglia.tuttiGiocano(false);

	}
}