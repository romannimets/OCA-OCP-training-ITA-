package designPatternsAndPrinciples;

@FunctionalInterface
	public interface CheckCaratteristica {
		// Metodo astratto test che verrà implementato dalle classi che implementano
		// CheckCaratteristica
		boolean test(Animale2 a);
	}
