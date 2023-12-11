package designPatternsAndPrinciples;

public class Lemure extends Primate implements HaLaCoda {
	public int age = 10;

	@Override
	public boolean laCodaEAStrisce() {
		return true;
	}

	@Override
	public String toString() {
		return "Sono un lemure! [age=" + age + "]";
	}
	
	

}
