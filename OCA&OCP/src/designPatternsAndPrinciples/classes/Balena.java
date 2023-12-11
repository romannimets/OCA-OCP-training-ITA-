package designPatternsAndPrinciples.classes;

import designPatternsAndPrinciples.interfaces.ViveInMare;

public class Balena implements ViveInMare {

	@Override
	public void emettiSuono() {
		System.out.println("la balena canta");
	}

}
