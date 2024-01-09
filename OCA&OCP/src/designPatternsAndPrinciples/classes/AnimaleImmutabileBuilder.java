package designPatternsAndPrinciples.classes;

import java.util.List;

//classe builder per AnimaleImmutabile
public class AnimaleImmutabileBuilder {

	// stesse proprietà di AnimaleImmutabile
	private String specie;
	private int eta;
	private List<String> cibiPreferiti;

	// solo i setter sono necessari, e restituiscomo tutti l' oggetto builder "this"
	// servono per settare le proprità concatenando le chiamate al builder

	public AnimaleImmutabileBuilder setSpecie(String specie) {
		this.specie = specie;
		return this;
	}

	public AnimaleImmutabileBuilder setEta(int eta) {
		this.eta = eta;
		return this;

	}

	public AnimaleImmutabileBuilder setCibiPreferiti(List<String> cibiPreferiti) {
		this.cibiPreferiti = cibiPreferiti;
		return this;
	}

	// metodo build() che interagisce direttamente con il costruttore di
	// AnimaleImmutabile. (in questo caso il costruttore è pubblico (v. impl
	// AnimaleImmutabile), ma se fosse stato privato, questo metodo build sarebbe
	// l'unico modo possibile per creare un AnimaleImmutabile.
	public AnimaleImmutabile build() {
		return new AnimaleImmutabile(specie, eta, cibiPreferiti);

		// PERCHE' RENDERE IL COSTGRUTTORE ACCESSIBILE SOLO DAL BUILDER?
		
		// Controllo del processo di costruzione: Limitare l'accesso al costruttore alle
		// classi client significa che l'oggetto può essere costruito solo attraverso il
		// builder. Ciò offre un maggiore controllo sul processo di costruzione e
		// assicura che le istanze della classe siano create in uno stato valido.

		// Immutabilità: Se la classe è progettata per essere immutabile, cioè una volta
		// creati gli oggetti non possono essere modificati, rendere il costruttore
		// accessibile solo al builder impedisce la creazione diretta di oggetti
		// immutabili senza il processo guidato del builder.

		// Chiarezza nell'uso: Il builder fornisce un'interfaccia chiara e coerente per
		// la creazione di oggetti complessi. Limitare l'accesso diretto al costruttore
		// favorisce l'uso del builder stesso, migliorando la chiarezza e la
		// comprensione del codice.

		// Aggiunta di logiche personalizzate: Se la creazione di un'istanza della
		// classe coinvolge logiche complesse, come la validazione dei parametri o la
		// generazione di valori predefiniti, è possibile incorporare queste logiche nel
		// builder senza esporle all'esterno.

		// Evitare costruttori con molti parametri: Rendere il costruttore accessibile
		// solo dal builder aiuta a evitare la creazione di costruttori con un numero
		// eccessivo di parametri, che possono rendere difficile la comprensione e
		// l'utilizzo della classe.

		// In sostanza, limitare l'accesso al costruttore e favorire l'uso del builder
		// fornisce un maggiore controllo, migliora la leggibilità del codice e facilita
		// la gestione di oggetti complessi.

	}

}
