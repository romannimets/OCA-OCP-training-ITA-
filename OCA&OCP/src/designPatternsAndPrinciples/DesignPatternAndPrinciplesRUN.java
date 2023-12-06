package designPatternsAndPrinciples;

import genericsAndCollections.Colors;

public class DesignPatternAndPrinciplesRUN {
	public static void main(String[] args) {
		// Design Patterns and Principles
		System.out.println("	" + Colors.BLUE_BACKGROUND_BRIGHT.get() + Colors.BLACK_UNDERLINED.get()
				+ Colors.BLACK_BOLD.get() + "Design Patterns and Principles" + Colors.RESET.get());
		// Using Variables in Lambdas
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Designing an Interface" + Colors.RESET.get());

		// Creazione di un'istanza di Aquila e chiamata dei suoi metodi
		Aquila aquila = new Aquila(); //vedi impl.
		try {
			int aperturaAlareAquila = aquila.getAperturaAlare();
			System.out.println("Apertura alare dell'aquila: " + aperturaAlareAquila);

			aquila.atterra();
			//
		} catch (Exception e) {
			System.err.println("Errore durante la chiamata del metodo getAperturaAlare: " + e.getMessage());
		}

		// Creazione di un'istanza di Leone e chiamata dei suoi metodi
		Leone leone = new Leone(); //vedi impl.
		boolean quadrupedeLeone = leone.isQuadrupede();
		boolean cacciareCorrendoLeone = leone.puoCacciareCorrendo();
		double maxVelocitaLeone = leone.getMaxVelocita();

		System.out.println("Il leone è quadrupede? " + quadrupedeLeone);
		System.out.println("Il leone può cacciare correndo? " + cacciareCorrendoLeone);
		System.out.println("Velocità massima del leone: " + maxVelocitaLeone);

		// Chiamata del metodo statico calcolaVelocita direttamente dall'interfaccia
		float spazio = 500;
		double tempo = 5;
		double velocitaCalcolata = Volo.calcolaVelocita(spazio, tempo);

		System.out.println("Velocità calcolata: " + velocitaCalcolata);
		
		//Una classe può anche implementare più interfacce:
		
		
		
		
	}

}
