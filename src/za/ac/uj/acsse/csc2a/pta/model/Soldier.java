package za.ac.uj.acsse.csc2a.pta.model;

// class inherits from Person and uses the abstract factory
public class Soldier extends Person implements CrimeProduct {

	private String guntype;

	public Soldier(String name, int iD, String colorCode, int xValue,
			int yValue, String guntype) {
		super(name, iD, colorCode, xValue, yValue);
		this.guntype = guntype;
	}

	public String getGuntype() {
		return guntype;
	}

	public void setGuntype(String guntype) {
		this.guntype = guntype;
	}

	@Override
	public void accept(IDrawVisitor visitor) {
		visitor.draw(this);
		
	}
	
}
