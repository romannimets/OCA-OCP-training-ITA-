package designPatternsAndPrinciples;
//Esempio di una classe che utilizza il Singleton DepositoFieno

public class AllenatoreLama {
	public boolean alimentaLama(int numeroDiLama) {
		int quantitaNecessaria = 5 * numeroDiLama;
		DepositoFienoSingleton depositoFieno = DepositoFienoSingleton.getInstance();
		if (depositoFieno.getQuantitaFieno() < quantitaNecessaria) {
			depositoFieno.aggiungiFieno(quantitaNecessaria + 10);
		}
		boolean alimentati = depositoFieno.rimuoviFieno(quantitaNecessaria);
		return alimentati;
	}
}