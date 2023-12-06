package designPatternsAndPrinciples;

import genericsAndCollections.Colors;

public class DesignPatternAndPrinciplesRUN {
	public static void main(String[] args) {
		// Design Patterns and Principles
		System.out.println("	" + Colors.BLUE_BACKGROUND_BRIGHT.get() + Colors.BLACK_UNDERLINED.get()
				+ Colors.BLACK_BOLD.get() + "Design Patterns and Principles" + Colors.RESET.get());
		// Using Variables in Lambdas
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Designing an Interface" + Colors.RESET.get());

		// Creazione di un'istanza di Aquila e chiamata dei suoi metodi
		Aquila aquila = new Aquila(); // vedi impl.
		try {
			int aperturaAlareAquila = aquila.getAperturaAlare();
			System.out.println("Apertura alare dell'aquila: " + aperturaAlareAquila);

			aquila.atterra();
			//
		} catch (Exception e) {
			System.err.println("Errore durante la chiamata del metodo getAperturaAlare: " + e.getMessage());
		}

		// Creazione di un'istanza di Leone e chiamata dei suoi metodi
		Leone leone = new Leone(); // vedi impl.
		boolean quadrupedeLeone = leone.isQuadrupede();
		boolean cacciareCorrendoLeone = leone.puoCacciareCorrendo();
		double maxVelocitaLeone = leone.getMaxVelocita();

		System.out.println("Il leone è quadrupede? " + quadrupedeLeone);
		System.out.println("Il leone può cacciare correndo? " + cacciareCorrendoLeone);
		System.out.println("Velocità massima del leone: " + maxVelocitaLeone);

		// Chiamata del metodo statico calcolaVelocita direttamente dall'interfaccia
		float spazio = 500;
		double tempo = 5;
		double velocitaCalcolata = Volo.calcolaVelocita(spazio, tempo);

		System.out.println("Velocità calcolata: " + velocitaCalcolata);

		// Una classe può anche implementare più interfacce:
		Rana rana = new Rana(); // vedi impl.
		rana.salta();
		rana.nuota();
		System.out.println("Velocità massima della rana: " + rana.getMaxVelocita());
		System.out.println("La rana è un quadrupede: " + rana.isQuadrupede());

		// Defining a Functional Interface
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Defining a Functional Interface" + Colors.RESET.get());

		Tigre tigre = new Tigre(); // v.impl
		tigre.scatta(new Rana());
		tigre.scatta(new Aquila());

		// Implementing Functional Interfaces with Lambdas
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Implementing Functional Interfaces with Lambdas" + Colors.RESET.get());

		// v.impl di Animale 2 e del metodo stampa

		// Nel secondo parametro, l'interfaccia funzionale viene implementata con una
		// lambda.
		// 'a' rappresenta l'oggetto Animale su cui, dopo la freccia (->), verrà
		// applicata la logica.
		// In sostanza, a->a.puoVolare indica che Java deve chiamare un metodo con un
		// parametro Animale,
		// che deve ritornare il risultato del metodo puoVolare() sull'oggetto 'a'.

		// Nell'esempio successivo, la lambda viene utilizzata per testare diverse
		// caratteristiche degli animali.

		stampa(new Animale2("Pesce", false, true, false), a -> a.puoSaltare());
		stampa(new Animale2("Canguro", true, false, false), a -> a.puoSaltare());

		stampa(new Animale2("Pesce", false, true, false), a -> a.puoVolare());
		stampa(new Animale2("Aquila", false, false, true), a -> a.puoVolare());

		stampa(new Animale2("Aquila", false, false, true), a -> a.puoNuotare());
		stampa(new Animale2("Pesce", false, true, false), a -> a.puoNuotare());

		Animale2 pesce = new Animale2("Pesce", false, true, false);
		// SINTASSI DELLA LAMBDA
		// A SINISTRA DELLA FRECCIA vanno i parametri di input della lambda, che possono
		// essere consumati da un'interfaccia funzionale il cui metodo astratto ha lo
		// stesso numero di parametri del metodo astratto al suo interno, e i tipi sono
		// compatibili
		// A DESTRA DELLA FRECCIA c'è il corpo della lambda expression. può essere
		// consumato da un'interfaccia funzionale il cui metodo astratto ha un tipo
		// diritorno compatibile


		System.out.println("sintassi 1: ");
		stampa(pesce, a -> a.puoNuotare());

		// EQUIVALENTE A:

		// Specificando un singolo parametro con il nome a e dichiarando che il tipo è
		// Animal2, avvolgendo i parametri di input tra parentesi ().
		// L'operatore freccia -> separa il parametro dal corpo.
		// Il corpo contiene una o più linee di codice, inclusi parentesi graffe {}, un
		// punto e virgola ; e una dichiarazione di return.
		
		//Le parentesi intorno ai parametri di ingresso possono essere omesse se il parametro è solo uno(come nell'esempio sopra) 
		//Il tipo del paramentro è opzionale
		
		System.out.println("equivalente a sintassi 2: ");
		stampa(pesce, (Animale2 a) -> {
			return a.puoNuotare();
		});

	}

	// V. impl di CheckCaratteristica (@FunctionalInterface)
	// Implementazione del metodo 'stampa' che accetta un oggetto Animale2 e un
	// oggetto CheckCaratteristica.
	// CheckCaratteristica è un'interfaccia funzionale e viene implementata mediante
	// la lambda fornita come parametro.
	// Il metodo test della lambda viene chiamato, passando l'oggetto Animale2, e
	// viene verificata la caratteristica specificata.
	private static void stampa(Animale2 animale, CheckCaratteristica caratteristica) {
		if (caratteristica.test(animale))
			System.out.println(animale + " possiede la caratteristca cercata");
	}

}
