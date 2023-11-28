package genericsAndCollections;

import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

interface Flyer {
	void fly();
}

class HangGlider implements Flyer {
	public void fly() {
	}
}

class Goose implements Flyer {
	public void fly() {
	}
}

public class RUN_GenericsAndCollections {
	public static void main(String[] args) {

		// OCA COLLECTIONS REVIEW
		System.out.println("	" + Colors.BLUE_BACKGROUND_BRIGHT.get() + Colors.BLACK_UNDERLINED.get()
				+ Colors.BLACK_BOLD.get() + "OCA COLLECTIONS REVIEW" + Colors.RESET.get());
		// Array & ArrayList
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "Array & ArrayList"
				+ Colors.RESET.get());

		List<String> list = new ArrayList<>(); // empty list
		list.add("Fluffy"); // [Fluffy]
		list.add("Webby"); // [Fluffy, Webby]
		String[] array = new String[list.size()]; // empty array
		array[0] = list.get(1); // [Webby]
		array[1] = list.get(0); // [Webby, Fluffy]
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + "-"); // Output: Webby–Fluffy–
		System.out.println();
		String[] arr = { "criceto", "topo" };
		List<String> lista = Arrays.asList(arr); // ritorna una lista di grandezza FISSA
		System.out.println(lista);
		// lista.remove(1); NON SI PUO' PIU' FARE, throws UnsupportedOperationException
		// perchè la lista è SEMPRE collegata all'array di origine
		// perchè ho usato .asList. se avessi creato ista e poi fatto .add come sopra
		// si sarebbe potuto usare il .remove e cambiare le diemensioni di lista
		lista.set(1, "test"); // [criceto, test]
		arr[0] = "new"; // [new, test] //se cambio l'array da cui è nata la lista cambio anche la lista
		System.out.println(lista);
		String[] arr2 = lista.toArray(new String[0]); // 0 come dimensione iniziale perchè
		// poi aumenta a seconda della lista di partenza
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

		// Searching & Sorting
		System.out.println(Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "Searching & Sorting"
				+ Colors.RESET.get());

		int[] numbers = { 6, 9, 1, 8 };
		Arrays.sort(numbers); // [1,6,8,9] si sorta per poter fare binarySearch
		System.out.println(Arrays.binarySearch(numbers, 6)); // 1 perchè ha trovato 6 in pos. 1
		System.out.println(Arrays.binarySearch(numbers, 3)); // -2 perchè stampa 1 in meno del negativo
																// di dove il valore andrebbe inserito
																// 3 andrebbe a indice 1, negando e sottraendo
																// si ottiene -2

		// Stessa cosa con le liste
		List<Integer> l = Arrays.asList(9, 7, 5, 3);
		Collections.sort(l); // [3, 5, 7, 9]
		System.out.println(Collections.binarySearch(l, 3)); // 0
		System.out.println(Collections.binarySearch(l, 2)); // -1

		// Wrapper Classes & Autoboxing
		System.out.println(Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Wrapper Classes & Autoboxing" + Colors.RESET.get());
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(1); // viene aggiunto 1 (è un int, ma viene autoboxato a Integer)
		nums.add(new Integer(3)); // viene aggiunto 3 come Integer
									// deprecato da java 9, preferibile fare come nella riga sotto
		nums.add((Integer) 5); // viene aggiunto 5 come Integer -->nums: [1,3,5]
		System.out.println(nums);
		nums.remove(1); // viene rimosso il numero a indice 1--> [1,5]
		nums.remove((Integer) 5); // overload del remove che accetta l'oggetto (integer 5)
									// e non più l'indice come int. viene perciò rimosso 5
									// --> nums:[1]
		System.out.println(nums);
		int numero = nums.get(0); // funziona anche se nella lista c'è Integer e non int
									// perchè java unboxa automaticamente

		// GENERICS
		System.out.println("	" + Colors.GREEN_BACKGROUND_BRIGHT.get() + Colors.BLACK_UNDERLINED.get()
				+ Colors.BLACK_BOLD.get() + "GENERICS" + Colors.RESET.get());
		// Classi Generics
		System.out.println(Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "\nClassi Generics"
				+ Colors.RESET.get());

		// Cassa può contenere un generic (vedi implementazione), quindi in ogni volta
		// che si istanzia una Cassa
		// possiamo specificare al compilatore di che tipo sarà il suo contenuto
		Cassa<String> cassaString = new Cassa<>(); // questa istanza (cassa) può contenera una stringa
		cassaString.imballaCassa("Stringa");
		System.out.println(cassaString.getContenuto());

		Cassa<Integer> cassaInteger = new Cassa<>(); // questa cassa può contenera un Integer
		cassaInteger.imballaCassa(1);
		System.out.println(cassaInteger.getContenuto());

		Cassa<List<Integer>> cassaLista = new Cassa<>(); // questa cassa può contenere una Lista di interi
		cassaLista.imballaCassa(Arrays.asList(1, 5, 16, 71, -2));
		System.out.println(cassaLista.getContenuto());

		Elefante elefante = new Elefante();
		elefante.setNome("Dumbo");

		Cassa<Elefante> cassaPerElefante = new Cassa<>();
		cassaPerElefante.imballaCassa(elefante);
		Elefante elefanteTraslocato = cassaPerElefante.svuotaCassa();
		System.out.println(elefanteTraslocato.getNome());

		// In questo esempio abbiamo visto come una cassa può contenere un elefante
		// senza sapere nulla di come
		// questo sia fatto ecc., perchè di base la cassa può contenere T;
		// Questa cassa può contenere perciò QUELLO CHE VOGLIAMO:

		// I GENERICS QUINDI SONO UTILI PERCHE' POSSIAMO CREARE CLASSI CON TIPI DEI
		// PARAMETRI CHE
		// NON C'ENTRANO NULLA L'UNO CON L'ALTRO
		// Interi, Stringhe, Liste, Elefanti,Robot, e altre

		// Inoltre nemmeno gli oggetti nella casa non devono sapere nulla di essa, NON
		// SERVE
		// che implementino l'interfaccia "Cassabile" o cose simili.

		// Spesso incontriamo i Type generics nel codiche che chiamiamo (tipo il
		// Framework Java Collections), e a meno che non stiamo scrivendo una libreria
		// lo
		// troveremo raramente nelle classi definite da noi

		// CLASSI GENERICS CON PIU' DI UN PARAMETRO:
		Elefante elefante2 = new Elefante();
		elefante2.setNome("Big Boy");
		Integer kilogrammi = 10_000; // "_" si può usare da java 7 in poi per rendere i grandi numeri
										// più leggibili, come il puntino nelle migliaia

		CassaConLimiteDimensioni<Elefante, Integer> c1 = new CassaConLimiteDimensioni<Elefante, Integer>(elefante2,
				kilogrammi);
		// Abbiamo creato c1 settando il tipo di entrambi i suoi paramentri (Elefante
		// per contenuto, Integer per limiteDimensioni;)
		System.out.println("La cassa contiene l'elefante di nome : " + c1.getContenuto().getNome()
				+ "\nLa cassa può contenere massimo " + c1.getLimiteDimensioni() + " kg");

		// Interfacce Generics
		System.out.println(Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "\nInterfacce Generics"
				+ Colors.RESET.get());

		// Abbiamo creato un'Interfaccia Shippable con parametro generico, per
		// implementarla
		// Ci sono 3 modi:

		// 1: Creare una classe concreta che la implementa dove specifico il tipo:
		// Questa cassa si occupa SOLO DI ELEFANTI
		CassaShippablePerElefante cse = new CassaShippablePerElefante(); // v. impl.
		System.out.print(elefante.getNome());
		cse.ship(elefante);

		// 2: Creare una classe Generica (così chi la chiama può specificare il tipo):
		CassaShippableAbstract<Elefante> csa = new CassaShippableAbstract<>(); // v.impl
		System.out.print(elefante.getNome());
		csa.ship(elefante);

		// 3: Senza generics, senza specificare tipi, creo la classe e implemento il
		// metodo passandogli Object.
		CassaShippable cs = new CassaShippable();
		System.out.print(elefante.getNome());
		cs.ship(elefante); // v. impl.

		// Metodi Generics
		System.out.println(Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "\nMetodi Generics"
				+ Colors.RESET.get());

		// È anche possibile dichiarare i generici a livello di metodo.
		// Questo è spesso utile per i metodi statici poiché non fanno parte di
		// un'istanza che può dichiarare il tipo.
		// Utilizzo del metodo generico con tipi diversi
		Cassa<Elefante> ce = spedisci(elefante);
		Cassa<Integer> ci = spedisci(4);
		Cassa<List<Elefante>> cle = spedisci(new ArrayList<>(Arrays.asList(elefante, elefante2)));
		// sintasi alternativa
		RUN_GenericsAndCollections.<Elefante>spedisci(elefante);

		// BOUNDS(vincoli) E WILDCARDS (caratteri Jolly(?))
		System.out.println("\n	" + Colors.PURPLE_BACKGROUND_BRIGHT.get() + Colors.BLACK_UNDERLINED.get()
				+ Colors.BLACK_BOLD.get() + "BOUNDS(vincoli) E WILDCARDS (caratteri Jolly(?)) " + Colors.RESET.get());

		// Un tipo parametro bounded è un tipo generico con dei limiti specificati
		// Un wildcard generic type è un Generic sconosciuto rappresentato da (?)
		// Il Generic wildcard si può usare in 3 modi:

		// 1: Unbounded Wildcards
		System.out.println(Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "\nUnbounded Wildcards"
				+ Colors.RESET.get());
		// Usiamo ? per dire che per il Generic va bene QUALSIASI TIPO:
		List<String> ls = new ArrayList<>();
		ls.add("stringa1");

		List<Elefante> le = new ArrayList<>();
		le.add(elefante2);
		le.add(elefante);

		printList(ls); // v.impl. FUNZIONA CON LISTE DI TUTTI I TIPI
		printList(le);

		// 2: Upper-Bounded Wildcards
		System.out.println(Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "\nUpper-Bounded Wildcards"
				+ Colors.RESET.get());
		// Ci serve un metodo che restituisce la somma di una lista di numeri(Number)
		// Number è una superclasse per tipi numerici con segno, come Integer, Long,
		// Double, Float, Short, e Byte.

		// Dobbiamo fare in modo che il metodo accetti in ingresso una lista di TUTTO
		// CIO' CHE ESTENDE Number
		// Creazione di una lista di numeri (Number)

		List<Number> anyNumbers = new ArrayList<>();

		// Aggiunta di numeri di diversi tipi alla lista
		anyNumbers.add(1); // Aggiunto un intero (Integer)
		anyNumbers.add(1.5); // Aggiunto un numero in virgola mobile (Double)
		anyNumbers.add(1.01); // Aggiunto un numero in virgola mobile (Double)
		anyNumbers.add(100L); // Aggiunto un numero long (Long)
		// Chiamata al metodo total passando la lista di numeri
		total(anyNumbers); // Il metodo accetta una lista di qualsiasi tipo che estenda Number

		// RICORDA
		// LA LISTA DIVENTA IMMUTABILE QUANDO USIAMO UNBOUNDED E UPPER BOUNDED
		List<?> li = new ArrayList<String>();
		// li.add("ciao"); //NON COMPILA
		List<? extends Number> ln = new ArrayList<Integer>();
		// ln.add(1); NON COMPILA!

		// esempio con interfacce
		List<Goose> lGeese = new ArrayList<Goose>(); // sottoclasse di flyer
		List<HangGlider> lHangGliders = new ArrayList<HangGlider>(); // sottoclasse fi flyer
		List<Flyer> lFlyers = new ArrayList<Flyer>(); // interfaccia
		// una lista di Flyers può essere passata a entrambi i metodi
		anyFlyer(lFlyers); // (v.Impl.) accetta List<Flyers>
		groupOfFlyers(lFlyers); // (v.Impl.) accetta List<? extends Flyers>

		// una lista di Geese può essere pasata solo al metodo con upper bound

		// anyFlyer(lGeese); NON COMPILA PERCHè List<Flyers> != List<Geese>
		groupOfFlyers(lGeese); // COMPILA perchè List<? extends Flyers> va bene con List<Geese>
		groupOfFlyers(lHangGliders); // idem con HangGliders

		// GRAZIE AI GENERICS E ALL'UPPER BOUNDED WILDCARD ABBIAMO UN METODO CHE FA
		// VOLARE INSIEME SOLO GRUPPI DI VOLATILI DELLO STESSO TIPO. OCHE E DELTAPLANI
		// NON VOLANO INSIEME, MA OCHE CON OCHE SI, E DELTAPLANI CON DELTAPLANI PURE

		// 3: Lower-Bounded Wildcards
		System.out.println(Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "\nLower-Bounded Wildcards"
				+ Colors.RESET.get());

		// Abbiamo bisogno di un metodo che può "quack" a due liste, una di stringhe e
		// una di Object:

		List<String> strings = new ArrayList<String>();
		strings.add("tweet");
		System.out.println("Strings: " + strings);
		List<Object> objects = new ArrayList<Object>(strings);
		System.out.println("Objects: " + objects);
		System.out.println("Strings: ");
		addSound(strings); // v. impl. addSound funziona con TUTTO CIO' CHE E' Lista di STRING oppure
							// SUPERCLASSE DI STRING. guarda bene le varie versioni del metodo(v.impl)
		System.out.println("Objects: ");
		addSound(objects);

		// Putting it all together
		System.out.println(Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "\nPutting it all together"
				+ Colors.RESET.get());

	}

	// Dichiarazione di metodo statico con parametro di tipo generico
	// A meno che un metodo non ottenga il parametro di tipo generico formale dalla
	// classe/interfaccia (Come i metodi ship di prima), viene specificato
	// immediatamente prima del tipo di ritorno del metodo
	public static <T> Cassa<T> spedisci(T t) {
		System.out.println("Preparando " + t);
		return new Cassa<T>();
	}

	// Metodo con parametro di tipo generico formale prima del tipo di ritorno void
	public static <T> void sink(T t) {
	}

	// Metodo con tipo di ritorno boolean e parametro di tipo generico formale
	public static <T> boolean boolReturn(T t) {
		return true;
	}

	// Metodo con tipo di ritorno uguale al parametro di tipo generico formale
	public static <T> T identity(T t) {
		return t;
	}

	// Il seguente metodo non compila poiché omesso il parametro di tipo generico
	// formale
	// e il compilatore non può dedurlo automaticamente
	// La correzione sarebbe:
	public static <T> T noGood(T t) {
		return t;
	}
	// Così invece
	// NON COMPILA public static T noGood(T t) { return t; } // NON COMPILA

	// metodo che stampa una Lista di ? (qualsiasi cosa)
	public static void printList(List<?> list) {
		System.out.print("{");
		for (Object x : list) {
			System.out.print(x);
		}
		System.out.println("}");

	}

	// Metodo che somma i valori di una lista di Number, che essi siano Integer,
	// Long, Double, Float, Short, e Byte).
	// UPPER-BOUNDED WILCARD che dice: va bene tutto basta che estenda Number
	public static float total(List<? extends Number> list) {
		float count = 0;
		for (Number number : list) {
			count += number.floatValue();
		}
		System.out.println("la somma dei valori della lista è:" + count);
		return count;
	}

	// METODO CHE ACCETTA UNA LISTA DI FLYER
	public static void anyFlyer(List<Flyer> flyer) {
		System.out.println("anyFlyer flying");
	}

	// ACCETTA UNA LISTA DI QUALSIASI COSA IMPLEMENTI FLYER (la keyword rimane
	// extends anche se flyer è un'interfaccia)
	public static void groupOfFlyers(List<? extends Flyer> flyer) {
		System.out.println("groupOfFlyers flying");
	}

	// Versione con generics non delimitati:
	// Non compila perché i generics non delimitati sono immutabili.
	// Tentare di aggiungere un elemento a una lista con generics non delimitati non
	// è consentito.
	// Errore di compilazione: "Il metodo add(capture#1-of ?) nella classe
	// List<capture#1-of ?>
	// non è applicabile agli argomenti (String)"
	public static void addSound1(List<?> list) {
		// list.add("quack"); // Commentato poiché causa errore di compilazione
	}

	// Versione con generics delimitati superiormente:
	// Non compila perché i generics delimitati superiormente sono immutabili.
	// Tentare di aggiungere un elemento a una lista con generics delimitati
	// superiormente non è consentito.
	// Errore di compilazione: "Il metodo add(capture#1-of ? extends Object) nella
	// classe
	// List<capture#1-of ? extends Object> non è applicabile agli argomenti
	// (String)"
	public static void addSound2(List<? extends Object> list) {
		// list.add("quack"); // Commentato poiché causa errore di compilazione
	}

	// Versione con generics esatti:
	// Compila correttamente, ma accetta solo List<Object>, non List<String>.
	// Con i generics, è necessario passare un tipo esatto e List<String> non è un
	// sottotipo di List<Object>.
	// Errore di compilazione: "Il metodo add(Object) nella classe List<Object> non
	// è applicabile
	// agli argomenti (String)"
	public static void addSound3(List<Object> list) {
		// list.add("quack"); // Commentato poiché causa errore di compilazione
	}

	// Versione corretta utilizzando generics delimitati inferiormente:
	// Compila correttamente e accetta sia List<Object> che List<String>.
	// Consente l'aggiunta di elementi grazie al delimitatore inferiore <? super
	// String>.
	public static void addSound(List<? super String> list) {
		list.add("quack");
		System.out.println("Dopo l'applicazione di addSound, la lista è: " + list);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
