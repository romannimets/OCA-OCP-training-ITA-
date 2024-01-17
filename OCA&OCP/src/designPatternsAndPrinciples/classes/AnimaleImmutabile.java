package designPatternsAndPrinciples.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un oggetto immutabile che descrive un animale con specifiche proprietà.
 * Le istanze di questa classe non possono essere modificate una volta create.
 */
public final class AnimaleImmutabile {

    // Proprietà immutabili
    private final String specie;
    private final int eta;
    private final List<String> cibiPreferiti;

    /**
     * Costruttore per inizializzare tutte le proprietà dell'animale immutabile.
     *
     * @param specie         La specie dell'animale.
     * @param eta            L'età dell'animale.
     * @param cibiPreferiti  Una lista immutabile dei cibi preferiti dell'animale.
     * @throws RuntimeException se la lista di cibi preferiti è null.
     */
    public AnimaleImmutabile(String specie, int eta, List<String> cibiPreferiti) {
        this.specie = specie;
        this.eta = eta;

        // Validazione e creazione di una copia per la lista di cibi preferiti
        if (cibiPreferiti == null) {
            throw new RuntimeException("La lista di cibi preferiti è obbligatoria");
        }
        this.cibiPreferiti = new ArrayList<>(cibiPreferiti);
    }

    /**
     * Restituisce la specie dell'animale.
     *
     * @return La specie dell'animale.
     */
    public String getSpecie() {
        return specie;
    }

    /**
     * Restituisce l'età dell'animale.
     *
     * @return L'età dell'animale.
     */
    public int getEta() {
        return eta;
    }

    /**
     * Restituisce il conteggio dei cibi preferiti dell'animale.
     *
     * @return Il conteggio dei cibi preferiti.
     */
    public int getConteggioCibiPreferiti() {
        return cibiPreferiti.size();
    }

    /**
     * Restituisce un cibo preferito dell'animale in base all'indice.
     *
     * @param indice L'indice del cibo preferito.
     * @return Il cibo preferito in base all'indice.
     */
    public String getCiboPreferito(int indice) {
        return cibiPreferiti.get(indice);
    }

    // Aggiungere altri metodi se necessario

    // Riassunto dell'implementazione dell'oggetto immutabile:
    // - Tutte le proprietà vengono inizializzate nel costruttore.
    // - Le proprietà sono dichiarate come private e final per garantire l'immutabilità.
    // - Non sono presenti setter methods per evitare modifiche dello stato dell'oggetto.
    // - Una copia di sicurezza viene utilizzata per la lista dei cibi preferiti,
    //   garantendo che l'oggetto rimanga immutabile anche se la lista originale cambia.
    // - La classe è dichiarata come final per prevenire la creazione di sottoclassi che
    //   potrebbero introdurre mutabilità.
    // - Thread-safety è garantita poiché lo stato dell'oggetto non può essere modificato
    //   una volta creato.
}
