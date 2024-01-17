package genericsAndCollections.classes;

/**
 * La classe Cassa rappresenta una cassa contenente un oggetto di tipo generico.
 *
 * @param <T> Il tipo di oggetto contenuto nella cassa, specificato al momento
 *            dell'istanziazione.
 */
public class Cassa<T> {

	/**
	 * Contenuto attuale della cassa.
	 */
	private T contenuto;

	/**
	 * Svuota la cassa restituendo il suo contenuto.
	 *
	 * @return Il contenuto della cassa.
	 */
	public T svuotaCassa() {
		return contenuto;
	}

	/**
	 * Imballa la cassa con il nuovo contenuto specificato.
	 *
	 * @param contenuto Il nuovo contenuto da inserire nella cassa.
	 */
	public void imballaCassa(T contenuto) {
		this.contenuto = contenuto;
	}

	/**
	 * Ottiene il contenuto attuale della cassa.
	 *
	 * @return Il contenuto della cassa.
	 */
	public T getContenuto() {
		return contenuto;
	}

	/**
	 * Imposta il contenuto della cassa con il nuovo valore specificato.
	 *
	 * @param contenuto Il nuovo contenuto da impostare nella cassa.
	 */
	public void setContenuto(T contenuto) {
		this.contenuto = contenuto;
	}
}

//T è un tipo generico, quando si istanzierà T bisognerà specificare al compilatore 
//che cosa sarà T per quella particolare istanza

//A type parameter can be named anything you want. The convention is to use single 
//uppercase letters to make it obvious that they aren’t real class names. The following are 
//common letters to use:
//■ E for an element
//■ K for a map key
//■ V for a map value
//■ N for a number
//■ T for a generic data type
//■ S, U, V, and so forth for multiple generic types