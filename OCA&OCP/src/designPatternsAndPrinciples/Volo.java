package designPatternsAndPrinciples;

public interface Volo {

	public int getAperturaAlare() throws Exception; // metodo che dichiara un'eccezione. Le regole della programmazione
													// in Java richiedono che se un'interfaccia dichiara di lanciare
													// un'eccezione, ogni classe che la implementa deve gestire o
													// dichiarare l'eccezione nel suo contratto.

	public static final int MAX_SPEED = 100; // costante statica disponibili ovunque nell'applicazione

	public default void atterra() { // Questo è un metodo di default, il che significa che fornisce
									// un'implementazione di default nel caso in cui una classe che implementa
									// l'interfaccia non fornisca una sua implementazione.
		
		System.out.println("L'animale sta atterrando");
	}

	public static double calcolaVelocita(float spazio, double tempo) { // metodo statico disponibile in tutta
																		// l'applicazione (NON SI PUO' OVERRIDARE)
		return spazio / tempo;
	}
}
