package functionalProgramming;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

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
		// In questo caso, su1 è un Supplier che fornisce un'implementazione del metodo
		// get dell'interfaccia Supplier. Il metodo di riferimento StringBuilder::new
		// viene utilizzato come implementazione di get. Questo significa che quando
		// chiami su1.get(), otterrai una nuova istanza di StringBuilder

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
		 * esempio, possiamo stampare due StringBuilder (uno vuoto, uno vlorizzato con
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

		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Consumer e BiConsumer\n".toUpperCase() + Colors.RESET.get());
		/*
		 * Si usa il Consumer per fare qualcosa con un parametro ma senza restituire
		 * nulla. Il BiConsumer funziona analogamente ma con 2 parametri
		 * 
		 * A parte i metodi di default, queste due interfacce funzionali appaiono così:
		 * 
		 * @FunctionalInterface public class Consumer<T> { void accept(T t); }
		 * 
		 * @FunctionalInterface public class BiConsumer<T, U> { void accept(T t, U u); }
		 * 
		 */

		// Method reference che equivale a una lambda expression x ->
		// System.out.println(x)

		// stiamo fornendo un'implementazione del metodo accept dell'interfaccia
		// Consumer.
		// In questo caso, stai utilizzando il metodo di riferimento System.out::println
		// per implementare il metodo accept, che accetta una stringa e la stampa su
		// standard output.
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = x -> System.out.println(x); // lambda expression

		c1.accept("Stampa consumer 1");
		c2.accept("Stampa consumer 2");

		// Utilizzo del BiConsumer per inserire coppie chiave-valore in una mappa
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "BiConsumer:\n".toUpperCase() + Colors.RESET.get());

		// Creazione di una mappa di tipo <String, Integer>
		Map<String, Integer> map = new HashMap<>();

		// Utilizzo di un metodo di riferimento per inserire una coppia chiave-valore
		// nella mappa
		BiConsumer<String, Integer> b1 = map::put;
		// Utilizzo di una lambda expression equivalente
		BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);

		// Chiamata al BiConsumer b1 per inserire una coppia chiave-valore nella mappa
		b1.accept("Pollo", 7);

		// Chiamata al BiConsumer b2 per inserire un'altra coppia chiave-valore nella
		// mappa
		b2.accept("Pulcino", 1);

		// Stampa della mappa per verificare che entrambi i BiConsumer siano stati
		// chiamati
		System.out.println("Mappa dopo l'utilizzo di BiConsumers: " + map);

		// Utilizzo del BiConsumer con tipi generici uguali (String)
		System.out.println("\n" + Colors.WHITE_BOLD.get() + "BiConsumer con tipi generici uguali:\n".toUpperCase()
				+ Colors.RESET.get());

		// Creazione di un'altra mappa di tipo <String, String>
		Map<String, String> map2 = new HashMap<>();

		// Utilizzo di un metodo di riferimento per inserire una coppia chiave-valore
		// nella seconda mappa
		BiConsumer<String, String> b3 = map2::put;
		// Utilizzo di una lambda expression equivalente
		BiConsumer<String, String> b4 = (k, v) -> map2.put(k, v);

		// Chiamata al BiConsumer b3 per inserire una coppia chiave-valore nella seconda
		// mappa
		b3.accept("Pollo", "Coccodè");

		// Chiamata al BiConsumer b4 per inserire un'altra coppia chiave-valore nella
		// seconda mappa
		b4.accept("Pulcino", "Pio Pio");

		// Stampa della seconda mappa per verificare che entrambi i BiConsumer siano
		// stati chiamati
		System.out.println("Seconda mappa dopo l'utilizzo di BiConsumers: " + map2);

		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Predicate e BiPredicate:\n".toUpperCase() + Colors.RESET.get());
		/**
		 * Utilizzo di Predicate e BiPredicate: Si utilizzano le interfacce funzionali
		 * Predicate e BiPredicate per testare condizioni su uno o due parametri
		 * rispettivamente. Le interfacce funzionali Predicate e BiPredicate sono
		 * definite come segue:
		 * 
		 * @FunctionalInterface public class Predicate<T> { boolean test(T t); }
		 * 
		 * @FunctionalInterface public class BiPredicate<T, U> { boolean test(T t, U u);
		 *                      }
		 * 
		 *                      Oltre ai metodi di default forniti dalle interfacce,
		 *                      queste interfacce funzionali possono essere implementate
		 *                      utilizzando sia riferimenti a metodi che espressioni
		 *                      lambda, offrendo flessibilità nella scrittura del
		 *                      codice.
		 */

		System.out.println("\n" + Colors.WHITE_BOLD.get() + "Predicate:\n".toUpperCase() + Colors.RESET.get());

		// Creazione di un Predicate che testa se una stringa è vuota
		Predicate<String> p1 = String::isEmpty;
		// Utilizzo di una lambda expression equivalente
		Predicate<String> p2 = x -> x.isEmpty();

		// Test della condizione con il Predicate p1
		System.out.println("Test con p1: " + p1.test(""));

		// Test della condizione con il Predicate p2
		System.out.println("Test con p2: " + p2.test(""));

		// Utilizzo di BiPredicate per testare una condizione con due parametri
		System.out.println("\n" + Colors.WHITE_BOLD.get() + "BiPredicate:\n".toUpperCase() + Colors.RESET.get());

		// Creazione di un BiPredicate che testa se una stringa inizia con un prefisso
		BiPredicate<String, String> biPred1 = String::startsWith;
		// Utilizzo di una lambda expression equivalente
		BiPredicate<String, String> biPred2 = (string, prefix) -> string.startsWith(prefix);

		// Test della condizione con il BiPredicate b1
		System.out.println("Test con b1: " + biPred1.test("chicken", "chick"));

		// Test della condizione con il BiPredicate b2
		System.out.println("Test con b2: " + biPred2.test("chicken", "chick"));

		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Function e BiFunction:\n".toUpperCase() + Colors.RESET.get());

		/**
		 * Implementazione di Function e BiFunction:
		 * 
		 * Le interfacce funzionali Function e BiFunction sono utilizzate per
		 * trasformare uno o due parametri rispettivamente in un valore di un tipo
		 * potenzialmente diverso e restituirlo. Le interfacce funzionali sono definite
		 * come segue:
		 * 
		 * @FunctionalInterface public class Function<T, R> { R apply(T t); }
		 * 
		 * @FunctionalInterface public class BiFunction<T, U, R> { R apply(T t, U u); }
		 * 
		 * 
		 *                      Oltre ai metodi di default forniti dalle interfacce,
		 *                      queste interfacce funzionali possono essere implementate
		 *                      utilizzando sia riferimenti a metodi che espressioni
		 *                      lambda, offrendo flessibilità nella scrittura del
		 *                      codice.
		 */

		// Utilizzo di Function per trasformare una stringa nella sua lunghezza
		System.out.println("\n" + Colors.WHITE_BOLD.get() + "Function:\n".toUpperCase() + Colors.RESET.get());

		// Creazione di una Function che trasforma una stringa nella sua lunghezza
		Function<String, Integer> f1 = String::length;
		// Utilizzo di una lambda expression equivalente
		Function<String, Integer> f2 = x -> x.length();

		// Applicazione della Function f1 sulla stringa "cluck"
		System.out.println("Lunghezza di 'cluck' con f1: " + f1.apply("cluck"));

		// Applicazione della Function f2 sulla stringa "cluck"
		System.out.println("Lunghezza di 'cluck' con f2: " + f2.apply("cluck"));

		// Utilizzo di BiFunction per concatenare due stringhe
		System.out.println("\n" + Colors.WHITE_BOLD.get() + "BiFunction:\n".toUpperCase() + Colors.RESET.get());

		// Creazione di una BiFunction che concatena due stringhe
		BiFunction<String, String, String> biFu1 = String::concat;
		// Utilizzo di una lambda expression equivalente
		BiFunction<String, String, String> biFu2 = (string, toAdd) -> string.concat(toAdd);

		// Applicazione della BiFunction b1 sulle stringhe "baby " e "chick"
		System.out.println("Concatenazione con biFu1: " + biFu1.apply("baby ", "chick"));

		// Commento esplicativo: Il risultato dell'applicazione della BiFunction b1
		// sulle stringhe "baby " e "chick" viene stampato su standard output.

		// Applicazione della BiFunction b2 sulle stringhe "baby " e "chick"
		System.out.println("Concatenazione con biFu2: " + biFu2.apply("baby ", "chick"));

		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Unary e Binary Operator:\n".toUpperCase() + Colors.RESET.get());
		/**
		 * Implementazione di UnaryOperator e BinaryOperator:
		 * 
		 * Le interfacce funzionali UnaryOperator e BinaryOperator rappresentano
		 * funzioni particolari. Richiedono che tutti i tipi di parametro siano dello
		 * stesso tipo. Un UnaryOperator trasforma il suo valore in uno dello stesso
		 * tipo, ad esempio, incrementare di uno è un'operazione unaria; infatti
		 * UnaryOperator estende Function.
		 * 
		 * Un BinaryOperator unisce due valori dello stesso tipo in uno. Aggiungere due
		 * numeri è un'operazione binaria. Analogamente, BinaryOperator estende
		 * BiFunction.
		 * 
		 * Omettendo eventuali metodi di default o statici, le interfacce sono definite
		 * come segue:
		 * 
		 * @FunctionalInterface public class UnaryOperator<T> extends Function<T, T> { T
		 *                      apply(T t) }
		 * 
		 * @FunctionalInterface public class BinaryOperator<T> extends BiFunction<T, T,
		 *                      T> { T apply(T t1, T t2)}
		 * 
		 *                      Se si osserva la documentazione, si noterà che questi
		 *                      metodi sono effettivamente dichiarati sulla superclasse
		 *                      Function/BiFunction.
		 */

		// Utilizzo di UnaryOperator per trasformare una stringa in maiuscolo
		System.out.println("\n" + Colors.WHITE_BOLD.get() + "Unary Operator:\n".toUpperCase() + Colors.RESET.get());

		// Creazione di un UnaryOperator che trasforma una stringa in maiuscolo (method
		// reference)
		UnaryOperator<String> unOp1 = String::toUpperCase;
		// Utilizzo di una lambda expression equivalente
		UnaryOperator<String> unOp2 = x -> x.toUpperCase();

		// Applicazione dell'UnaryOperator u1 sulla stringa "chirp"
		System.out.println("Stringa in maiuscolo con unOp1: " + unOp1.apply("chirp"));

		// Applicazione dell'UnaryOperator u2 sulla stringa "chirp"
		System.out.println("Stringa in maiuscolo con unOp1: " + unOp2.apply("chirp"));

		// Utilizzo di BinaryOperator per concatenare due stringhe
		System.out.println("\n" + Colors.WHITE_BOLD.get() + "Binary Operator:\n".toUpperCase() + Colors.RESET.get());

		// Creazione di un BinaryOperator che concatena due stringhe
		BinaryOperator<String> binOp1 = String::concat;
		// Utilizzo di una lambda expression equivalente
		BinaryOperator<String> binOp2 = (string, toAdd) -> string.concat(toAdd);

		// Applicazione del BinaryOperator b1 sulle stringhe "baby " e "chick"
		System.out.println("Concatenazione con binOp1: " + binOp1.apply("baby ", "chick"));

		// Applicazione del BinaryOperator b2 sulle stringhe "baby " e "chick"
		System.out.println("Concatenazione con binOp2: " + binOp2.apply("baby ", "chick"));

	}
}