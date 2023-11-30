package genericsAndCollections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

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

		// List, Sets, Maps,and Queues
		System.out.println("\n	 " + Colors.RED_BACKGROUND_BRIGHT.get() + Colors.BLACK_UNDERLINED.get()
				+ Colors.BLACK_BOLD.get() + "LIST, SETS, MAPS AND QUEUES" + Colors.RESET.get());
		// Metodi di Collection
		System.out.println(Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "\nMetodi di Collection"
				+ Colors.RESET.get());

		// add
		System.out.println(Colors.WHITE_BACKGROUND.get() + Colors.BLACK_BOLD.get() + "\nadd()" + Colors.RESET.get());

		// aggiunge un elemento nella Collection e ritorna un booleano per dire se ha
		// avuto successo. Firma: boolean add(E element)

		List<String> lString = new ArrayList<>();
		System.out.println(lString.add("Sparrow")); // ritorna (e stampa) true
		System.out.println(lString.add("Sparrow")); // ritorna (e stampa) true

		Set<String> set = new HashSet<>();
		System.out.println(set.add("Sparrow")); // ritorna (e stampa) true
		System.out.println(set.add("Sparrow")); // ritorna (e stampa) false (no duplicati nel set)

		// remove()
		System.out.println(Colors.WHITE_BACKGROUND.get() + Colors.BLACK_BOLD.get() + "\nremove()" + Colors.RESET.get());
		// Rimuove unsingolo valore corrispondente nella Collection e ritorna booleano
		// Firma: boolean remove(Object object)
		// C'è un overload del metodo: accetta un int, che funziona come indice

		List<String> uccelli = new ArrayList<>();
		uccelli.add("falco");
		uccelli.add("falco"); // ora uccelli è [falco, falco]
		System.out.println("lista di uccelli: " + uccelli);
		System.out.println("tentativo di rimuovere 'cardellino': " + uccelli.remove("cardellino")); // false (non c'è
																									// match)
		System.out.println("tentativo di rimuovere 'falco': " + uccelli.remove("falco"));
		System.out.println("lista di uccelli: " + uccelli);
		System.out.println("rimozione con remove(int index) a indice 0: " + uccelli.remove(0));
		System.out.println("lista di uccelli: " + uccelli);

		// isEmpty() and size()
		System.out.println(Colors.WHITE_BACKGROUND.get() + Colors.BLACK_BOLD.get() + "\nisEmpty() and size()"
				+ Colors.RESET.get());
		// Questi due metodi guardano il numero di elementi nella collection: uno
		// ritorna booleano e l'altro int:
		// Firme: "boolean isEmpty()" e "int size()"

		System.out.println("uccelli.isEmpty(): " + uccelli.isEmpty()); // true
		System.out.println("uccelli. size(): " + uccelli.size()); // 0
		uccelli.add("falco");
		uccelli.add("falco");
		System.out.println("uccelli dopo .add('falco') fatto 2 volte: " + uccelli);
		System.out.println("uccelli.isEmpty(): " + uccelli.isEmpty()); // false
		System.out.println("uccelli.size(): " + uccelli.size()); // 2

		// clear()
		System.out.println(Colors.WHITE_BACKGROUND.get() + Colors.BLACK_BOLD.get() + "\nclear()" + Colors.RESET.get());

		// Svuota la collection. Firma: void clear()
		uccelli.clear();
		System.out.println("uccelli dopo .clear " + uccelli); // []
		System.out.println("uccelli.isEmpty(): " + uccelli.isEmpty()); // true
		System.out.println("uccelli.size(): " + uccelli.size()); // 0

		// contains()
		System.out
				.println(Colors.WHITE_BACKGROUND.get() + Colors.BLACK_BOLD.get() + "\ncontains()" + Colors.RESET.get());
		// controlla se un certo valore è nella collection, ritorna booleano
		// Firma: boolean contains(Object object)

		uccelli.add("falco");
		uccelli.add("pettirosso");
		System.out.println("uccelli: " + uccelli);
		System.out.println("uccelli.contains(\"pettirosso\"): " + uccelli.contains("pettirosso")); // true
		System.out.println("uccelli.contains(\"cardellino\"): " + uccelli.contains("cardellino")); // false

		// List interface
		System.out.println(Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "\nList interface"
				+ Colors.RESET.get());
		// LIST SI USA QUANDO VUOI UNA COLLECTION ORDINATA CHE PUO' CONTENERE DUPLICATI

		// ArrayList: Array ridimensionabile, ottimo per la ricerca frequente degli
		// elementi. Cresce automaticamente con l'aggiunta di elementi.
		// Da utilizzare quando si legge più spesso che scrivere, o con la stessa
		// frequenza. Ricerche in tempo costante.
		// PIU'VELOCE PER LEGGERE

		List<String> arrayList = new ArrayList<>();

		// LinkedList: Implementa List e Queue. Consente operazioni in tempo costante
		// sia all'inizio che alla fine, ma tempo lineare per indice arbitrario.
		// Utile come coda. Aggiunta, rimozione e accesso all'inizio e alla fine in
		// tempo costante.
		// PIU'VELOCE PER TOGLIERE E METTERE
		List<String> linkedList = new LinkedList<>();

		// Vector: Implementazione più vecchia, sostituita da ArrayList. Più lento ma
		// thread-safe. Non raccomandato per il nuovo codice.
		// Conosciuto per la compatibilità con codice più vecchio.
		List<String> vectorList = new Vector<>();

		// Stack: Struttura dati per aggiungere e rimuovere elementi dall'alto. Estende
		// Vector, non raccomandato per il nuovo codice.
		// Utilizza ArrayDeque al suo posto per uno stack.
		Deque<String> stack = new ArrayDeque<>();

		// Aggiunge l'elemento alla fine della lista
		arrayList.add("SD");
		System.out.println("arrayList.add(\"SD\")-> " + arrayList);

		// Aggiunge l'elemento all'indice specificato, spostando gli altri elementi
		arrayList.add(0, "NY");
		System.out.println("arrayList.add(0, \"NY\")-> " + arrayList);

		// Sostituisce l'elemento all'indice specificato con uno nuovo
		arrayList.set(1, "FL");
		System.out.println("arrayList.set(1, \"FL\")-> " + arrayList);

		// Rimuove la prima occorrenza dell'elemento specificato dalla lista
		arrayList.remove("NY");
		System.out.println("arrayList.remove(\"NY\")-> " + arrayList);

		// Rimuove l'elemento all'indice specificato dalla lista
		arrayList.remove(0);
		System.out.println("arrayList.remove(0)-> " + arrayList);

		// Esempio di interrogazione della lista:

		// Aggiunge l'elemento alla fine della lista
		arrayList.add("OH");
		arrayList.add("CO");
		arrayList.add("NJ");
		System.out.println("Lista nuovamente riempita-> " + arrayList);

		// Ottiene l'elemento all'indice specificato
		String state = arrayList.get(0);
		System.out.println("arrayList.get(0)(elemento all'indice 0)-> " + state);

		// Ottiene l'indice della prima occorrenza dell'elemento specificato nella lista
		int indexNJ = arrayList.indexOf("NJ");
		System.out.println("arrayList.indexOf(\"NJ\") (ottiene l'indice del primo \"NJ\")-> " + indexNJ);

		// Ottiene l'indice dell'ultima occorrenza dell'elemento specificato nella lista
		int lastIndexCO = arrayList.lastIndexOf("CO");
		System.out.println("arrayList.lastIndexOf(\"CO\") (ottiene l'indice dell'ultima \"CO\")-> " + lastIndexCO);

		// Esempio in cui indexOf ritorna -1
		int indexNotFound = arrayList.indexOf("CA");
		System.out.println("arrayList.indexOf(\"CA\") (ottiene l'indice di \"CA\")-> " + indexNotFound);

		// Esempio in cui lastIndexOf ritorna -1
		int lastIndexNotFound = arrayList.lastIndexOf("CA");
		System.out.println("arrayList.lastIndexOf(\"CA\") (ottiene l'ultimo indice di \"CA\")-> " + lastIndexNotFound);

		// Set interface
		System.out.println(Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "\nSet interface"
				+ Colors.RESET.get());
		// SI USA SET QUANDO NON VUOI DUPLICATI E NON TI INTERESSA L'ORDINE

		// HashSet: Mette gli elementi in unas HashTable, ciò significa che usa il
		// metodo hashCode degli oggetti per recuperarli più efficientemente
		// hashCode: numero che mette le istanze di una classe in un numero finito di
		// categorie, rendendo più facile accedervi)
		// è il più usato, perdi l'ordinamento ma è molto veloce

		Set<Integer> hashSet = new HashSet<>();
		System.out.println("hashSet.add(66)->" + hashSet.add(66)); // true
		System.out.println("hashSet.add(10)->" + hashSet.add(10)); // true
		System.out.println("hashSet.add(66)->" + hashSet.add(66)); // false(doppione)
		System.out.println("hashSet.add(8)->" + hashSet.add(8)); // true
		System.out.print("hashSet(66 non è stato aggiunto la seconda volta): ");
		for (Integer integer : hashSet)
			System.out.print(integer + ","); // 66,8,10

		// TreeSet: Struttura ad alber, ordinato. Aggiungere e legere elementi è sempre
		// più lento.
		// Implementa NavigableSet, che permette di suddividere la collezione

		NavigableSet<Integer> treeSet = new TreeSet<>();
		// TreeSet<Integer> treeSet = new TreeSet<>(); STESSA COSA

		for (int i = 1; i <= 20; i++)
			treeSet.add(i);
		System.out.println("\nNavigable TreeSet:" + treeSet);
		// E lower(E e): ritorna l'elemento più grande minore di e, se non c'è torna
		// null
		System.out.println("treeSet.lower(10)-> " + treeSet.lower(10)); // 9
		// E lower(E e): ritorna l'elemento più grande minore o uguale e, se non c'è
		// torna null
		System.out.println("treeSet.floor(10)-> " + treeSet.floor(10)); // 10
		// E lower(E e): ritorna l'elemento più piccolo maggiore o uguale e, se non c'è
		// torna null
		System.out.println("treeSet.ceiling(20)-> " + treeSet.ceiling(20)); // 20
		// E lower(E e): ritorna l'elemento più piccolo maggiore a e, se non c'è
		// torna null
		System.out.println("treeSet.higher(20)-> " + treeSet.higher(20)); // null
		// subSet: ritorna gli elementi compresi tra i due valori (primo compreso
		// secondo escluso)
		System.out.println("treeSet.subSet(12, 18)-> " + treeSet.subSet(12, 18));

		// Queue, Deque e Stack con ArrayDeque
		System.out.println(Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
		        + "\nQueue, Deque e Stack con ArrayDeque" + Colors.RESET.get());

		// Definizioni:
		// - Queue: Una coda (Queue) è una struttura dati che segue l'approccio FIFO
		// (First-In, First-Out). Gli elementi vengono aggiunti alla fine (back) e
		// rimossi dall'inizio (front) della coda. (A volte LIFO)
		// - Deque: Una double-ended queue (Deque) è una struttura dati che consente
		// l'aggiunta e la rimozione di elementi sia dalla fine che dall'inizio della
		// coda. Può essere utilizzata come una coda o uno stack. La pronuncia corretta
		// è "deck".
		// - Stack: Uno stack è una struttura dati che segue l'approccio LIFO (Last-In,
		// First-Out). Gli elementi vengono aggiunti e rimossi sempre dalla stessa
		// estremità, chiamata "top" in uno stack.

		// Differenza tra un ArrayDeque come stack o come coda:
		// una coda è simile a una fila di persone. Si entra in coda sul retro e si esce
		// dall'avanti.
		// Uno stack è simile a una pila di piatti. Metti il piatto in cima e lo togli
		// dalla cima. Poiché lo stack è implementato utilizzando ArrayDeque, ci
		// riferiamo a "top" e "front" in modo intercambiabile

		// Utilizzo di Queue con ArrayDeque
		Queue<Integer> queue = new ArrayDeque<>();
		System.out.println("Coda vuota: " + queue);

		// Metodi principali per Queue:
		// - add(E e): aggiunge un elemento in coda e ritorna true, altrimenti lancia
		// un'eccezione
		System.out.println("queue.add(1) -> " + queue.add(1));
		System.out.println("queue.add(2) -> " + queue.add(2)); // true
		System.out.println("Coda ora: " + queue);

		// - element(): ritorna il prossimo elemento senza rimuoverlo(FIRST-OUT nel
		// FIFO), altrimenti lancia un'eccezione
		System.out.println("queue.element() -> " + queue.element());

		// - offer(E e): aggiunge un elemento in coda e ritorna true o false (come
		// add(), ma senza eccezioni)
		System.out.println("queue.offer(10) -> " + queue.offer(10)); // true
		System.out.println("queue.offer(4) -> " + queue.offer(4)); // true
		System.out.println("Coda ora: " + queue);

		// - remove(): rimuove e ritorna il prossimo elemento (FIRST-OUT nel FIFO)
		System.out.println("queue.remove() -> " + queue.remove());
		System.out.println("Coda ora: " + queue);

		// - peek(): restituisce il prossimo elemento senza rimuoverlo, altrimenti
		// ritona NULL
		System.out.println("queue.peek() -> " + queue.peek());

		// - poll(): rimuove e ritorna il prossimo elemento, restituisce null se vuota
		System.out.println("queue.poll() -> " + queue.poll());
		System.out.println("Coda ora: " + queue);

		// Utilizzo di Deque con ArrayDeque (anche come Stack)
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		System.out.println("\nDeque vuoto: " + deque);

		// Metodi principali per Deque:
		// - add(E e): aggiunge un elemento alla fine della deque e ritorna true,
		// altrimenti lancia un'eccezione
		System.out.println("deque.add(1) -> " + deque.add(1));
		System.out.println("deque.add(2) -> " + deque.add(2)); // true
		System.out.println("Deque ora: " + deque);

		// - element(): ritorna il prossimo elemento senza rimuoverlo (dal front nella
		// deque, FIRST-OUT nel FIFO)
		System.out.println("deque.element() -> " + deque.element());

		// - offer(E e): aggiunge un elemento alla fine della deque e ritorna true o
		// false (come add(), ma senza eccezioni)
		System.out.println("deque.offer(10) -> " + deque.offer(10)); // true
		System.out.println("deque.offer(4) -> " + deque.offer(4)); // true
		System.out.println("Deque ora: " + deque);

		// - remove(): rimuove e ritorna il prossimo elemento (dal front nella deque,
		// FIRST-OUT nel FIFO)
		System.out.println("deque.remove() -> " + deque.remove());
		System.out.println("Deque ora: " + deque);

		// - push(E e): aggiunge un elemento all'inizio della deque (come offer(), ma
		// all'inizio)
		deque.push(5);
		System.out.println("Deque dopo push(5) -> " + deque);

		// - pop(): rimuove e ritorna il prossimo elemento dall'inizio della deque (come
		// poll(), ma all'inizio)
		System.out.println("deque.pop() -> " + deque.pop());
		System.out.println("Deque ora: " + deque);

		// Metodi aggiuntivi per Deque (anche per Queue):
		// - peek(): restituisce il prossimo elemento senza rimuoverlo (dal front nella
		// deque)
		System.out.println("deque.peek() -> " + deque.peek());

		// - poll(): rimuove e ritorna il prossimo elemento dall'inizio della deque,
		// restituisce null se vuota
		System.out.println("deque.poll() -> " + deque.poll());
		System.out.println("Deque ora: " + deque);

		// Nota: Non è possibile utilizzare push nè pop sulla Queue in quanto è
		// un'operazione
		// specifica dello Stack e Deque.
		// La seguente riga causerebbe un errore di compilazione:
		// queue.push(3); // Errore di compilazione

		// IN SOSTANZA, per accedere/aggiungere elementi:
		// LIFO (stack(deque))-> push/poll/peek
		// FIFO (single-ended-queue)-> offer/poll/peek

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
