package za.ac.uj.acsse.csc2a.pta.model;

public class DesignThings implements IDrawable{
	/*
	 * Class to design or draw various things which are to be
	 * displayed on the layout 
	 */
	private int width;
	private int height;
	private int rows;
	private int cols;
	private Things[][] things;
	
	public DesignThings(Things[][] things){
		this.things=things;
	}
	
	public Things getThing(int row,int col){
		return things[row][col];
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getRows() {
		return things.length;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return things[0].length;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	//overriding the draw method to display things in layout
	@Override
		public void accept(IDrawVisitor visitor) {
		visitor.draw(this);
	}

	
	
    
	
}
