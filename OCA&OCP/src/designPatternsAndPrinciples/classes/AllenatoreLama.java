package designPatternsAndPrinciples.classes;

/**
 * La classe AllenatoreLama rappresenta un allenatore che gestisce
 * l'alimentazione di un gruppo di lama utilizzando il pattern Singleton
 * per accedere al deposito di fieno.
 */
public class AllenatoreLama {

    /**
     * Alimenta un numero specificato di lama, garantendo che ci sia
     * abbastanza fieno disponibile nel deposito.
     *
     * @param numeroDiLama Il numero di lama da alimentare.
     * @return True se tutte le lama sono state alimentate con successo,
     *         False altrimenti.
     */
    public boolean alimentaLama(int numeroDiLama) {
        // Calcola la quantità necessaria di fieno per le lama
        int quantitaNecessaria = 5 * numeroDiLama;

        // Ottieni l'istanza del deposito di fieno utilizzando il Singleton
        DepositoFienoSingleton depositoFieno = DepositoFienoSingleton.getInstance();

        // Verifica se c'è abbastanza fieno nel deposito, altrimenti aggiungine
        if (depositoFieno.getQuantitaFieno() < quantitaNecessaria) {
            depositoFieno.aggiungiFieno(quantitaNecessaria + 10);
        }

        // Rimuovi la quantità necessaria di fieno e restituisci l'esito dell'operazione
        boolean alimentati = depositoFieno.rimuoviFieno(quantitaNecessaria);
        return alimentati;
    }
}
