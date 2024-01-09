package designPatternsAndPrinciples.classes;

//Classe factory per la creazione di oggetti di tipo Cibo in base al nome dell'animale
public class CiboFactory {
	
	// Metodo statico che restituisce un oggetto di tipo Cibo in base al nome
	// dell'animale

	// Nel contesto del pattern factory, l'approccio statico consente di utilizzare
	// la factory senza dover istanziare la classe CiboFactory, semplificando così
	// l'utilizzo del metodo getCibo in altre parti del codice senza la necessità di
	// creare un'istanza dell'oggetto factory.
	public static Cibo getCibo(String nomeAnimale) {

		// Utilizza switch case per gestire i diversi casi di animali e restituire il
		// cibo appropriato (v.impl dei vari cibi)
		switch (nomeAnimale) {
		case "zebra":
			return new Fieno(100);
		case "coniglio":
			return new Mangime(5);
		case "capra":
			return new Mangime(30);
		case "orso polare":
			return new Pesce(10);
		default:
			// Se il nome dell'animale non corrisponde a nessun caso previsto, solleva
			// un'eccezione.
			throw new UnsupportedOperationException("ANIMALE NON SUPPORTATO: " + nomeAnimale);
			
		}
	}
}
