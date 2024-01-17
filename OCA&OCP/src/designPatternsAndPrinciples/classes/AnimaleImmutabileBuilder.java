package designPatternsAndPrinciples.classes;

import java.util.List;

/**
 * La classe {@code AnimaleImmutabileBuilder} rappresenta il builder per la creazione di oggetti della classe
 * {@link AnimaleImmutabile}. Questo approccio di progettazione consente un controllo più stretto sul processo
 * di costruzione degli oggetti, offrendo numerosi vantaggi.
 * 
 * <p><strong>Controllo del processo di costruzione:</strong> Limitare l'accesso al costruttore alle classi client
 * significa che l'oggetto può essere costruito solo attraverso il builder. Questo offre un maggiore controllo sul
 * processo di costruzione e assicura che le istanze della classe siano create in uno stato valido.</p>
 * 
 * <p><strong>Immutabilità:</strong> Se la classe è progettata per essere immutabile, cioè una volta creati gli
 * oggetti non possono essere modificati, rendere il costruttore accessibile solo al builder impedisce la creazione
 * diretta di oggetti immutabili senza il processo guidato del builder.</p>
 * 
 * <p><strong>Chiarezza nell'uso:</strong> Il builder fornisce un'interfaccia chiara e coerente per la creazione di
 * oggetti complessi. Limitare l'accesso diretto al costruttore favorisce l'uso del builder stesso, migliorando la
 * chiarezza e la comprensione del codice.</p>
 * 
 * <p><strong>Aggiunta di logiche personalizzate:</strong> Se la creazione di un'istanza della classe coinvolge logiche
 * complesse, come la validazione dei parametri o la generazione di valori predefiniti, è possibile incorporare
 * queste logiche nel builder senza esporle all'esterno.</p>
 * 
 * <p><strong>Evitare costruttori con molti parametri:</strong> Rendere il costruttore accessibile solo dal builder
 * aiuta a evitare la creazione di costruttori con un numero eccessivo di parametri, che possono rendere difficile
 * la comprensione e l'utilizzo della classe.</p>
 * 
 * <p>In sintesi, limitare l'accesso al costruttore e favorire l'uso del builder fornisce un maggiore controllo,
 * migliora la leggibilità del codice e facilita la gestione di oggetti complessi.</p>
 * 
 * @see AnimaleImmutabile
 */
public class AnimaleImmutabileBuilder {

    private String specie;
    private int eta;
    private List<String> cibiPreferiti;

    /**
     * Imposta la specie dell'animale.
     * 
     * @param specie La specie dell'animale.
     * @return L'istanza corrente del builder.
     */
    public AnimaleImmutabileBuilder setSpecie(String specie) {
        this.specie = specie;
        return this;
    }

    /**
     * Imposta l'età dell'animale.
     * 
     * @param eta L'età dell'animale.
     * @return L'istanza corrente del builder.
     */
    public AnimaleImmutabileBuilder setEta(int eta) {
        this.eta = eta;
        return this;
    }

    /**
     * Imposta la lista di cibi preferiti dell'animale.
     * 
     * @param cibiPreferiti La lista di cibi preferiti dell'animale.
     * @return L'istanza corrente del builder.
     */
    public AnimaleImmutabileBuilder setCibiPreferiti(List<String> cibiPreferiti) {
        this.cibiPreferiti = cibiPreferiti;
        return this;
    }

    /**
     * Costruisce un'istanza di {@link AnimaleImmutabile} con le proprietà configurate attraverso il builder.
     * 
     * @return Un'istanza immutabile di AnimaleImmutabile.
     */
    public AnimaleImmutabile build() {
        return new AnimaleImmutabile(specie, eta, cibiPreferiti);
    }

}

