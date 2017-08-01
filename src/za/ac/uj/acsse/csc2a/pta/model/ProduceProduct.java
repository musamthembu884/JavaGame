package za.ac.uj.acsse.csc2a.pta.model;

public class ProduceProduct extends CrimeFactory{

	@Override
	public CrimeProduct ProducePolice(String name, int iD, String colorCode,
			int xValue, int yValue, String position) {
		
		return new Police(name, iD, colorCode, xValue, yValue, position);
	}

	@Override
	public CrimeProduct ProduceSoldier(String name, int iD, String colorCode,
			int xValue, int yValue, String guntype) {
		
		return new Soldier(name, iD, colorCode, xValue, yValue, guntype);
	}

}
