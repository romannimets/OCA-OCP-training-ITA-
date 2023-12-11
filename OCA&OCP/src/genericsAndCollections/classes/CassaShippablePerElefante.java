package genericsAndCollections.classes;

import genericsAndCollections.interfaces.Shippable;

public class CassaShippablePerElefante implements Shippable<Elefante> {

	@Override
	public void ship(Elefante t) {
		System.out.println(" é stato spedito");
	}

}
