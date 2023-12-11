package designPatternsAndPrinciples.classes;

//Implementazione del Singleton DepositoFieno

//Nota: Abbiamo aggiunto il modificatore synchronized a
//addHay(), removeHay() e getHayQuantity(). Discuteremo questi
//concetti in dettaglio nel capitolo "Concurrency". Per ora, è
//sufficiente sapere che prevengono l'esecuzione simultanea di due
//processi sullo stesso metodo nello stesso momento.

public class DepositoFienoSingleton {
 private int quantita = 0;

 // Costruttore privato per evitare l'istanziazione diretta
 private DepositoFienoSingleton() {
 }

 // Singleton instance creata come variabile statica final
 private static final DepositoFienoSingleton instance = new DepositoFienoSingleton();

 // Metodo pubblico per ottenere l'istanza del Singleton
 public static DepositoFienoSingleton getInstance() {
     return instance;
 }

 // Metodi per aggiungere, rimuovere e ottenere la quantità di fieno
 public synchronized void aggiungiFieno(int quantitaAggiunta) {
     quantita += quantitaAggiunta;
 }

 public synchronized boolean rimuoviFieno(int quantitaRimossa) {
     if (quantita < quantitaRimossa) return false;
     quantita -= quantitaRimossa;
     return true;
 }

 public synchronized int getQuantitaFieno() {
     return quantita;
 }
}