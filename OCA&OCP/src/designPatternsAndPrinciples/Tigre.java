package designPatternsAndPrinciples;

public class Tigre implements Scattare { //v.impl di Scattare

	
	public void scatta(Animale animale) {
		System.out.println("L'animale sta facendo uno scatto velocissimo! sta inseguendo "+animale.toString());
	}
	@Override
	public String toString() {
		return "Tigre";
	}
}
