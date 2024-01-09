package designPatternsAndPrinciples.classes;
//Classe concreta che estende Cibo, rappresentando il tipo specifico di cibo "Mangime".
//Implementa il metodo "consumato" definendo il comportamento quando il mangime viene mangiato.
//Questa classe fa parte del pattern Factory in quanto fornisce un'implementazione concreta
//per la creazione di oggetti del tipo Cibo.
public class Mangime extends Cibo{
	
	// Costruttore che richiama il costruttore della classe base e inizializza la
	// quantità di mangime.
	public Mangime(int quantita) {
		super(quantita);
	}

    // Implementazione del metodo astratto "consumato" che stampa un messaggio quando il mangime viene mangiato.
	@Override
	public void mangiato() {
		System.out.println("MANGIME mangiato: " + getQuantita());
		
	}

}
