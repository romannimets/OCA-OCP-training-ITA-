package designPatternsAndPrinciples.classes;

// Definizione della classe Animale2 (Classe apposita)
public class Animale2 {
	private String specie;
	private boolean puoSaltare;
	private boolean puoNuotare;
	private boolean puoVolare;

	// Costruttore che inizializza gli attributi della classe
	public Animale2(String nomeSpecie, boolean saltatore, boolean nuotatore, boolean volante) {
		specie = nomeSpecie;
		puoSaltare = saltatore;
		puoNuotare = nuotatore;
		puoVolare = volante;
	}

	// Metodo che restituisce true se l'animale può saltare
	public boolean puoSaltare() {
		return puoSaltare;
	}

	// Metodo che restituisce true se l'animale può nuotare
	public boolean puoNuotare() {
		return puoNuotare;
	}

	// Metodo che restituisce true se l'animale può volare
	public boolean puoVolare() {
		return puoVolare;
	}

	// Metodo che restituisce la specie dell'animale come stringa
	public String toString() {
		return specie;
	}

	
}
