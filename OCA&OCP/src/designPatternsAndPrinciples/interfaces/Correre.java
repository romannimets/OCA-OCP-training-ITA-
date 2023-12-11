package designPatternsAndPrinciples.interfaces;

/**
 * Interfaccia Correre che estende l'interfaccia Camminare. Aggiunge un nuovo
 * metodo puoCacciareCorrendo() e ridefinisce il metodo astratto
 * getMaxVelocita(). Quando un'interfaccia estende un'altra interfaccia con
 * metodi della stessa firma, non è necessario ridichiararli.
 */
public interface Correre extends Camminare {

	/**
	 * Aggiunta di un nuovo metodo: puoCacciareCorrendo().
	 * 
	 * @return true se l'animale può cacciare correndo.
	 */
	public abstract boolean puoCacciareCorrendo();

	/**
	 * Metodo astratto ereditato da Camminare. Ora abbiamo due dichiarazioni di
	 * getMaxVelocita() (una da Camminare e una da Correre). La dichiarazione in
	 * Correre sovrascrive quella in Camminare.
	 * 
	 * @return La velocità massima, da implementare nelle classi che implementano
	 *         Correre.
	 */
	abstract double getMaxVelocita();
}
