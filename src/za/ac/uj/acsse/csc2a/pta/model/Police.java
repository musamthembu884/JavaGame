package za.ac.uj.acsse.csc2a.pta.model;

/*
 * class inherits from Person and uses the abstract factory
 */
public class Police extends Person implements CrimeProduct {
	
	private String position;

	public Police(String name, int iD, String colorCode, int xValue,
			int yValue, String position) {
		super(name, iD, colorCode, xValue, yValue);
		this.position = position;
	}

	public String getUniformColor() {
		return position;
	}

	public void setUniformColor(String position) {
		this.position = position;
	}

	@Override
	public void accept(IDrawVisitor visitor) {
		visitor.draw(this);
		
	}

	
	

}
