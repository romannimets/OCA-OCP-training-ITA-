package genericsAndCollections.classes;
//Compile error ma funziona
//Senza uso di Generics

import genericsAndCollections.interfaces.Shippable;

public class CassaShippable implements Shippable {

	@Override
	public void ship(Object t) {
		System.out.println(" é stato spedito");

	}

}
