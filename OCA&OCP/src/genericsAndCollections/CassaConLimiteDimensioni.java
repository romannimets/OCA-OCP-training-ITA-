package genericsAndCollections;
public class CassaConLimiteDimensioni<T, U> {
	private T contenuto;
	private U limiteDimensioni;
	
	//T è ciò che mettiamo nella cassa, U è la dimensione massima della cassa.
	//SONO ENTRAMBI GENERICS

	public CassaConLimiteDimensioni(T contenuto, U limiteDimensioni) {
		this.contenuto = contenuto;
		this.limiteDimensioni = limiteDimensioni;

	}

	public T getContenuto() {
		return contenuto;
	}

	public void setContenuto(T contenuto) {
		this.contenuto = contenuto;
	}

	public U getLimiteDimensioni() {
		return limiteDimensioni;
	}

	public void setLimiteDimensioni(U limiteDimensioni) {
		this.limiteDimensioni = limiteDimensioni;
	}
}