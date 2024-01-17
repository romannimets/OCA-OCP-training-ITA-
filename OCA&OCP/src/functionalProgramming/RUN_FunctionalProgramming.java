package functionalProgramming;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

import functionalProgramming.classes.FamigliaDiGorilla;
import functionalProgramming.interfaces.Gorilla;
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

//		
//		  Functional Interfaces:
//		  
//		  | Interface          | Parameters | Return Type | Single Abstract Method  |
//		  |---------------------|------------|-------------|--------------------------|
//		  | Supplier<T>         | 0          | T           | get                      |
//		  | Consumer<T>         | 1 (T)       | void        | accept                   |
//		  | BiConsumer<T, U>    | 2 (T, U)    | void        | accept                   |
//		  | Predicate<T>        | 1 (T)       | boolean     | test                     |
//		  | BiPredicate<T, U>   | 2 (T, U)    | boolean     | test                     |
//		  | Function<T, R>      | 1 (T)       | R           | apply                    |
//		  | BiFunction<T, U, R> | 2 (T, U)    | R           | apply                    |
//		  | UnaryOperator<T>    | 1 (T)       | T           | apply                    |
//		  | BinaryOperator<T>   | 2 (T, T)    | T           | apply                    |
//		 

		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Working with Built-In Functional Interfaces".toUpperCase() + Colors.RESET.get());
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Supplier\n".toUpperCase() + Colors.RESET.get());
		/*
		 * Supplier<T> - Interfaccia funzionale che rappresenta un fornitore senza
		 * argomenti, restituendo un risultato di tipo T.
		 * 
		 * Metodo astratto: T get()
		 */
		/*
		 * Un Supplier viene utilizzato quando si desidera generare o fornire valori
		 * senza richiedere alcun input. L'interfaccia Supplier è definita come:
		 *
		 * @FunctionalInterface public interface Supplier<T> { T get(); }
		 */

		// DUE modi di implementare un Supplier

		// Utilizzo di un riferimento a un metodo
		// Il riferimento al metodo LocalDate::now
		// viene utilizzato per creare un Supplier da assegnare a una variabile
		// intermedia s1.
		Supplier<LocalDate> s1 = LocalDate::now;

		// Utilizzo di un'espressione lambda
		Supplier<LocalDate> s2 = () -> LocalDate.now();

		// Ottenimento dei risultati dai Supplier

		LocalDate d1 = s1.get();
		LocalDate d2 = s2.get();
		System.out.println("date create con il supplier: ");
		System.out.println(d1);
		System.out.println(d2);

		/*
		 * Un Supplier è spesso utilizzato nella costruzione di nuovi oggetti. Ad
		 * esempio, possiamo stampare due StringBuilder (unop vuopto, uno vlorizzato con
		 * .append():
		 */
		Supplier<StringBuilder> su1 = StringBuilder::new; // Utilizzo di un riferimento a un metodo
		Supplier<StringBuilder> su2 = () -> new StringBuilder(); // Utilizzo di un'espressione lambda
		System.out.println(
				"\nDopo aver costruito un supplier di StringBuilder, che ne restituisce un'istanza, possiamo stampare i sb costruiti con supplier.get()");
		System.out.println("sb vuoto: " + su1.get());
		System.out.println("sb con append" + su2.get().append("Stringa agginta con .append()"));

		/*
		 * Questa volta, utilizziamo un riferimento a un costruttore per creare
		 * l'oggetto. Abbiamo usato i generics per dichiarare il tipo di Supplier che
		 * stiamo usando.
		 */
		Supplier<ArrayList<String>> s3 = ArrayList<String>::new;
		ArrayList<String> a1 = s3.get();
		System.out.println(a1);

		/*
		 * Abbiamo un Supplier di tipo ArrayList<String>. Quindi, chiamare get() crea
		 * una nuova istanza di ArrayList<String>, che è il tipo generico del Supplier.
		 * In altre parole, abbiamo un generic che contiene un altro generic.
		 */
	}
}