package designPatternsAndPrinciples.interfaces;
//è un interfaccia funzionale perchè ha una sola e unica funzione (un singolo metodo astratto)

import designPatternsAndPrinciples.classes.Animale;

@FunctionalInterface
public interface Scattare {
	
	//accetta un animale che verrà inseguito
	public void scatta(Animale animale);
}

//Questa interfaccia non definisce nuovi metodi astratti, ma estende l'interfaccia Sprint.
//Poiché Sprint ha un solo metodo astratto (sprint()), anche Run è considerata un'interfaccia funzionale.

//public interface Run extends Scattare {}


//Questa interfaccia estende Sprint e definisce un nuovo metodo astratto sprint(Animal animal).
//Tuttavia, questo metodo astratto è una ridefinizione del metodo sprint() già presente in Sprint.
//Poiché il numero totale di metodi astratti nella gerarchia rimane uno, SprintFaster è anch'essa considerata un'interfaccia funzionale.

//public interface SprintFaster extends Scattare {
//public void sprint(Animal animal);
//}


//Questa interfaccia estende Sprint e definisce un metodo statico (skip) e un metodo di default (getHopCount).
//I metodi statici e i metodi di default non sono considerati metodi astratti, poiché forniscono un'implementazione.
//Quindi, nonostante Skip abbia più di un metodo nella sua dichiarazione, ha solo un metodo astratto (sprint() ereditato da Sprint).
//Quindi, anche Skip è considerata un'interfaccia funzionale.

//public interface Skip extends Scattare {
//public default int getHopCount(Kangaroo kangaroo) {return 10;}
//public static void skip(int speed) {}
//}


