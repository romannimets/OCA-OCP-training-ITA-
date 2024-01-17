package designPatternsAndPrinciples.interfaces;

import designPatternsAndPrinciples.classes.Animale;

/**
 * L'interfaccia Scattare definisce il comportamento di un oggetto che può eseguire scatti, inseguendo un animale.
 * Questa è un'interfaccia funzionale poiché contiene un solo metodo astratto.
 *
 * @param <Animal> Il tipo di animale che verrà inseguito durante lo scatto.
 */
@FunctionalInterface
public interface Scattare<Animal extends designPatternsAndPrinciples.classes.Animale> {

    /**
     * Metodo astratto che rappresenta l'azione di uno scatto veloce, inseguendo un animale.
     *
     * @param animale L'animale che viene inseguito durante lo scatto.
     */
    void scatta(Animal animale);
}

//Esempio di interfaccia funzionale estesa da un'interfaccia Run.
//Run rappresenta l'azione di correre dietro a un animale.

//public interface Run extends Scattare {}

//Esempio di interfaccia funzionale con un nuovo metodo astratto.
//SprintFaster rappresenta l'azione di uno sprint veloce dietro a un animale.

//public interface SprintFaster extends Scattare {
// /**
//  * Metodo astratto che rappresenta l'azione di uno sprint veloce, inseguendo un animale.
//  *
//  * @param animal L'animale che viene inseguito durante lo sprint.
//  */
// void sprint(Animal animal);
//}

//Esempio di interfaccia funzionale estesa da un'interfaccia Skip.
//Skip rappresenta l'azione di saltare dietro a un animale, con metodi statici e di default.

//public interface Skip extends Scattare {
// /**
//  * Metodo di default che restituisce il numero di salti di un canguro.
//  *
//  * @param kangaroo Il canguro di cui si vuole ottenere il numero di salti.
//  * @return Il numero di salti del canguro.
//  */
// default int getHopCount(Kangaroo kangaroo) {
//     return 10;
// }
//
// /**
//  * Metodo statico che rappresenta l'azione di saltare con una velocità specifica.
//  *
//  * @param speed La velocità con cui si desidera saltare.
//  */
// static void skip(int speed) {}
//}

