package designPatternsAndPrinciples.classes;

/**
 * La classe {@code Animale2} rappresenta un animale e ne definisce le
 * caratteristiche fondamentali, come la specie e le capacità di saltare,
 * nuotare e volare.
 * 
 * Questa classe fornisce un costruttore che inizializza gli attributi della
 * classe con i valori specificati e metodi di accesso per ottenere informazioni
 * sulle abilità dell'animale.
 */
public class Animale2 {
	private String specie;
	private boolean puoSaltare;
	private boolean puoNuotare;
	private boolean puoVolare;

	/**
	 * Costruttore che inizializza gli attributi della classe con i valori
	 * specificati.
	 * 
	 * @param nomeSpecie La specie dell'animale.
	 * @param saltatore  {@code true} se l'animale può saltare, altrimenti
	 *                   {@code false}.
	 * @param nuotatore  {@code true} se l'animale può nuotare, altrimenti
	 *                   {@code false}.
	 * @param volante    {@code true} se l'animale può volare, altrimenti
	 *                   {@code false}.
	 */
	public Animale2(String nomeSpecie, boolean saltatore, boolean nuotatore, boolean volante) {
		specie = nomeSpecie;
		puoSaltare = saltatore;
		puoNuotare = nuotatore;
		puoVolare = volante;
	}

	/**
	 * Metodo che restituisce {@code true} se l'animale può saltare, altrimenti
	 * {@code false}.
	 * 
	 * @return {@code true} se l'animale può saltare, altrimenti {@code false}.
	 */
	public boolean puoSaltare() {
		return puoSaltare;
	}

	/**
	 * Metodo che restituisce {@code true} se l'animale può nuotare, altrimenti
	 * {@code false}.
	 * 
	 * @return {@code true} se l'animale può nuotare, altrimenti {@code false}.
	 */
	public boolean puoNuotare() {
		return puoNuotare;
	}

	/**
	 * Metodo che restituisce {@code true} se l'animale può volare, altrimenti
	 * {@code false}.
	 * 
	 * @return {@code true} se l'animale può volare, altrimenti {@code false}.
	 */
	public boolean puoVolare() {
		return puoVolare;
	}

	/**
	 * Metodo che restituisce la specie dell'animale come stringa.
	 * 
	 * @return La specie dell'animale come stringa.
	 */
	public String toString() {
		return specie;
	}
}
