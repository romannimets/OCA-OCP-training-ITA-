package designPatternsAndPrinciples.classes;

import java.util.ArrayList;
import java.util.List;

public final class AnimaleImmutabile {
	// Proprietà immutabili
	private final String specie;
	private final int eta;
	private final List<String> cibiPreferiti;

	// Costruttore per inizializzare tutte le proprietà
	public AnimaleImmutabile(String specie, int eta, List<String> cibiPreferiti) {
		this.specie = specie;
		this.eta = eta;

		// Validazione e creazione di una copia per la lista di cibi preferiti
		if (cibiPreferiti == null) {
			throw new RuntimeException("La lista di cibi preferiti è obbligatoria");
		}
		this.cibiPreferiti = new ArrayList<>(cibiPreferiti);
	}

	// Metodo getter per la specie
	public String getSpecie() {
		return specie;
	}

	// Metodo getter per l'età
	public int getEta() {
		return eta;
	}

	// Metodo getter per il conteggio dei cibi preferiti
	public int getConteggioCibiPreferiti() {
		return cibiPreferiti.size();
	}

	// Metodo getter per ottenere un cibo preferito in base all'indice
	public String getCiboPreferito(int indice) {
		return cibiPreferiti.get(indice);
	}

//	 Riassunto dell'implementazione dell'oggetto immutabile: 

//	- Tutte le proprietà vengono inizializzate nel costruttore.
//	- Le proprietà sono dichiarate come private e final per garantire l'immutabilità. 
//	- Non sono presenti setter methods per evitare modifiche dello stato dell'oggetto. 
//	- Una copia copia di sicurezza viene utilizzata per la lista dei cibi preferiti, 
//		garantendo che l'oggetto rimanga immutabile anche se la lista originale cambia.
//	- La classe è dichiarata come final per prevenire la creazione di sottoclassi che 
//		potrebbero introdurre mutabilità.
//	- Thread-safety è garantita poiché lo stato dell'oggetto non può essere modificato 
//		una volta creato.	
}
