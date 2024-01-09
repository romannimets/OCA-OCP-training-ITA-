package designPatternsAndPrinciples.classes;

//Classe concreta che estende Cibo, rappresentando il tipo specifico di cibo "Pesce".
//Implementa il metodo "consumato" definendo il comportamento quando il pesce viene mangiato.
//Questa classe fa parte del pattern Factory in quanto fornisce un'implementazione concreta
//per la creazione di oggetti del tipo Cibo.
public class Pesce extends Cibo {
	// Costruttore che richiama il costruttore della classe base e inizializza la
	// quantità di mangime.
	public Pesce(int quantita) {
		super(quantita);
	}

	// Implementazione del metodo astratto "consumato" che stampa un messaggio
	// quando il pesce viene mangiato.
	@Override
	public void mangiato() {
		System.out.println("PESCE mangiato: " + getQuantita());

	}
}
