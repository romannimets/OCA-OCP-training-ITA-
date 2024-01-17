package genericsAndCollections.classes;

/**
 * La classe Elefante rappresenta un elefante con un nome.
 */
public class Elefante {

	private String nome;

	/**
	 * Restituisce il nome dell'elefante.
	 *
	 * @return Il nome dell'elefante.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Imposta il nome dell'elefante.
	 *
	 * @param nome Il nuovo nome dell'elefante.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce una rappresentazione in formato stringa dell'elefante.
	 *
	 * @return Una stringa che rappresenta l'elefante.
	 */
	@Override
	public String toString() {
		return "Elefante di nome " + nome + ", ";
	}
}
