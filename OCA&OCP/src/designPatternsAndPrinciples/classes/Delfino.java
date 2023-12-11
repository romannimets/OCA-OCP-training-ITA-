package designPatternsAndPrinciples.classes;

import designPatternsAndPrinciples.interfaces.ViveInMare;

public class Delfino implements ViveInMare {

	@Override
	public void emettiSuono() {
		System.out.println("il delfino fischia");
	}

}
