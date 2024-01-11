package designPatternsAndPrinciples.classes;

import designPatternsAndPrinciples.interfaces.ViveInMare;

/**
 * La classe {@code Oceanografo} rappresenta un professionista che si occupa di
 * studiare gli organismi marini. Fornisce un metodo {@code ascoltaSuono()} che
 * accetta un oggetto che implementa l'interfaccia {@code ViveInMare} e richiama
 * il metodo {@code emettiSuono()} di tale oggetto per ascoltare il suono emesso
 * dall'animale marino.
 */
public class Oceanografo {
	/**
	 * Metodo che ascolta il suono emesso da un animale marino.
	 * 
	 * @param animale Oggetto che implementa l'interfaccia {@code ViveInMare}.
	 */
	public void ascoltaSuono(ViveInMare animale) {
		animale.emettiSuono();
	}
}
