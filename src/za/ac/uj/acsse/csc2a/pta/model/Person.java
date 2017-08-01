package za.ac.uj.acsse.csc2a.pta.model;

/*
 * abstract class that demonstrates the use of visitor pattern
 * and creates an abstract with basic characteristics
 */
public abstract class Person implements IDrawable{
	private String Name;
	private int ID;
	private String ColorCode;
	private int xValue;
	private int yValue;
	public Person(String name, int iD, String colorCode, int xValue, int yValue) {
		super();
		Name = name;
		ID = iD;
		ColorCode = colorCode;
		this.xValue = xValue;
		this.yValue = yValue;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getColorCode() {
		return ColorCode;
	}
	public void setColorCode(String colorCode) {
		ColorCode = colorCode;
	}
	public int getxValue() {
		return xValue;
	}
	public void setxValue(int xValue) {
		this.xValue = xValue;
	}
	public int getyValue() {
		return yValue;
	}
	public void setyValue(int yValue) {
		this.yValue = yValue;
	}
	
	
	
	
	
}
