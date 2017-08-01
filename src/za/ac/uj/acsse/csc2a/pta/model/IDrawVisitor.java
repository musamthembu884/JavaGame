package za.ac.uj.acsse.csc2a.pta.model;

public interface IDrawVisitor {

	/*
	 * this interface will define a visitor class operation
	 * for each of the specified classes
	 */
	public void draw(DesignThings thing);
	public void draw(Soldier soldier);
	public void draw(Police police);
}
