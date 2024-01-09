package designPatternsAndPrinciples.classes;

//Classe astratta che rappresenta un tipo generico di cibo in un zoo.
//Ha una proprietà "quantita" per indicare la quantità di cibo disponibile.
//La classe è progettata secondo il pattern Factory, fornendo un metodo astratto "consumato"
//che sarà implementato dalle sottoclassi concrete per definire il comportamento specifico
//quando il cibo viene consumato.
public abstract class Cibo {
	private int quantita;

	// Costruttore che inizializza la quantità di cibo.
	public Cibo(int quantita) {
		this.quantita = quantita;
	}

	// Metodo getter per ottenere la quantità di cibo.
	public int getQuantita() {
		return quantita;
	}

	// Metodo astratto che rappresenta l'azione di consumare il cibo.
	public abstract void mangiato();

}
