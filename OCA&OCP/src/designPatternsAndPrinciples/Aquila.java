package designPatternsAndPrinciples;

public class Aquila extends Animale implements Volo{

	

	//Metodo overridato dell'interfaccia volo, in cui si fornisce l'apertura alare dell'aquila
	@Override
	public int getAperturaAlare() throws Exception {
		return 15;
	}
	
	public void atterra() {
		System.out.println("l'aquila sta atterrando fortissimo in picchiata");
	}

	@Override
	public String toString() {
		return "Aquila";
	}

}
