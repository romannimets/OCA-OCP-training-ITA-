package designPatternsAndPrinciples.interfaces;

/**
 * Interfaccia Camminare con metodi astratti isQuadrupede() e getMaxVelocita().
 * Un'interfaccia può contenere solo metodi astratti o metodi di default.
 */
public interface Camminare {

	/**
	 * Metodo astratto che deve essere implementato dalle classi che implementano
	 * l'interfaccia.
	 * 
	 * @return true se l'animale è un quadrupede.
	 */
	boolean isQuadrupede();

	/**
	 * Metodo astratto che deve essere implementato dalle classi che implementano
	 * l'interfaccia.
	 * 
	 * @return La velocità massima, da implementare nelle classi che implementano
	 *         Camminare.
	 */
	abstract double getMaxVelocita();
}
