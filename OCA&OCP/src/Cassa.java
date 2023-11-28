public class Cassa<T> {
    private T contenuto;

    public T svuotaCassa() {
        return contenuto;
    }

    public void imballaCassa(T contenuto) {
        this.contenuto = contenuto;
    }

	public T getContenuto() {
		return contenuto;
	}

	public void setContenuto(T contenuto) {
		this.contenuto = contenuto;
	}
    
    
}

//T è un tipo generico, quando si istanzierà T bisognerà specificare al compilatore 
//che cosa sarà T per quella particolare istanza

//A type parameter can be named anything you want. The convention is to use single 
//uppercase letters to make it obvious that they aren’t real class names. The following are 
//common letters to use:
//■ E for an element
//■ K for a map key
//■ V for a map value
//■ N for a number
//■ T for a generic data type
//■ S, U, V, and so forth for multiple generic types