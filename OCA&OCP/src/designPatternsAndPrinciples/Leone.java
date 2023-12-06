package designPatternsAndPrinciples;

/**
 * Implementazione della classe Leone che implementa l'interfaccia Correre. La
 * classe fornisce concrete implementazioni per i metodi astratti ereditati da
 * Correre e Camminare.
 */
public class Leone extends Animale implements Correre {

	/**
	 * Implementazione del metodo isQuadrupede() definito in Camminare.
	 * 
	 * @return true, poiché il leone è un quadrupede.
	 */
	@Override
	public boolean isQuadrupede() {
		return true;
	}

	/**
	 * Implementazione del metodo puoCacciareCorrendo() definito in Correre.
	 * 
	 * @return true, poiché il leone può cacciare correndo.
	 */
	@Override
	public boolean puoCacciareCorrendo() {
		return true;
	}

	/**
	 * Implementazione del metodo getMaxVelocita() definito in Correre. Nota: Questa
	 * implementazione sovrascrive quella di Camminare.
	 * 
	 * @return La velocità massima del leone, che è 100.
	 */
	@Override
	public double getMaxVelocita() {
		return 100;
	}

	@Override
	public String toString() {
		return "Leone";
	}

}