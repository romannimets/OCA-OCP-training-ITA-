package designPatternsAndPrinciples;

public class Rana extends Animale implements Saltare, Nuotare, Camminare {



	@Override
	public void nuota() {
		System.out.println("La rana sta nuotando");
	}

	@Override
	public void salta() {
		System.out.println("La rana salta");

	}

	@Override
	public boolean isQuadrupede() {
		return true;
	}

	@Override
	public double getMaxVelocita() {
		return 15;
	}
	@Override
	public String toString() {
		return "Rana";
	}

}
