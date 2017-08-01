package za.ac.uj.acsse.csc2a.pta.model;

public interface IDrawable {

	//this interface is to allow element object to accept the visitor
	//object so that visitor can handle operations of object
	public void accept(IDrawVisitor visitor);
}
