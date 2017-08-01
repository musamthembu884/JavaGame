package za.ac.uj.acsse.csc2a.pta.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import za.ac.uj.acsse.csc2a.pta.model.DesignThings;
import za.ac.uj.acsse.csc2a.pta.model.IDrawVisitor;
import za.ac.uj.acsse.csc2a.pta.model.Police;
import za.ac.uj.acsse.csc2a.pta.model.Soldier;
import za.ac.uj.acsse.csc2a.pta.model.Things;

public class GraphicsPaintVisitor implements IDrawVisitor{

	Graphics G;
	/*
	 * coordinates of grid and patroler 
	 */
	private static int box=70;
	private static int x=box/2;
	private static int y=box/2;
	private static int xPatrol=50;
	private static int yPatrol=300;
	
	public void setG(Graphics G){
		this.G=G;
	}
	
	@Override
	public void draw(DesignThings thing) {
		
		//ALL IMAGES ARE DOWNLOADEDE FROM GOOGLE
		BufferedImage rock=null;
		BufferedImage tree=null;
		BufferedImage house=null;
		
		try {
			//https://www.google.co.za/search?q=small+rock+images+60x60&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjUoeyzlujMAhXsC8AKHafBAe4Q_AUIBygB&biw=1242&bih=606#imgrc=BG1N4QfDmM7XgM%3A
			rock = ImageIO.read(new File("data/rocks.jpg"));
			//https://www.google.co.za/search?q=small+tree+images+60x60&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjUoeyzlujMAhXsC8AKHafBAe4Q_AUIBygB&biw=1242&bih=606#imgrc=BG1N4QfDmM7XgM%3A
			tree=ImageIO.read(new File("data/tree.jpg"));	
			https://www.google.co.za/search?q=small+animal+house+60x60&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjUoeyzlujMAhXsC8AKHafBAe4Q_AUIBygB&biw=1242&bih=606#imgrc=BG1N4QfDmM7XgM%3A
			house=ImageIO.read(new File("data/house.jpg"));
			
					
			} catch (IOException e) {
		
			e.printStackTrace();
		}

		for (int r=0;r<9;r++){
			for (int c=0;c<9;c++){
				x=r*box;
				y=c*box;
				
			
			   //getting different kinds of things like rocks and trees from file
				Things allThings =thing.getThing(r, c);
				
				switch(allThings){
				
				case ROCKS:
				{
					G.drawImage(rock,x, y,null);
					break;
				}
				case TREES:
				{	
					G.drawImage(tree,x, y,null);
					break;
				}
				case HOUSE:
				{
					G.drawImage(house,x, y,null);
					break;
				}
				default:
				{
					
					break;
				}
				
				
						
			}
		
			}
			}
		
	}

	/*
	 * using design pattern to draw all of the following methods
	 */
	@Override
	public void draw(Soldier soldier) {
		 BufferedImage army=null;
			
			try {
				army = ImageIO.read(new File("data/army.png"));	
						
				} catch (IOException e) {
				e.printStackTrace();
			}
		
		G.drawString(soldier.getName(), soldier.getxValue()+10, soldier.getyValue()-2);
		G.setColor(Color.RED);
		G.drawImage(army,soldier.getxValue(),soldier.getyValue() ,null);
		
	}

	@Override
	public void draw(Police police) {
        BufferedImage policeImage=null;
		
		try {
			policeImage = ImageIO.read(new File("data/police.jpg"));	
					
			} catch (IOException e) {
			e.printStackTrace();
		}
		G.drawString(police.getName(),police.getxValue()+12, police.getyValue()-2);
		G.setColor(Color.GRAY);
		G.drawImage(policeImage,police.getxValue(), police.getyValue(), null);
		
		
		
	}
	
	public void drawPatrol(int x,int y){
          BufferedImage patrol=null;
		
		try {
			patrol=ImageIO.read(new File("data/chiefPatrol.jpg"));
					
			} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		G.drawImage(patrol,x,y,null);
		
	}
	
	public void drawPlayer(int x,int y){
        BufferedImage patrol=null;
		
		try {
			patrol=ImageIO.read(new File("data/player2.jpg"));
					
			} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		G.drawImage(patrol,x,y,null);
		
	}
    public void drawHouse(int x,int y){
		
		
		G.setColor(Color.RED);
		G.fillRect(x, y, 50, 50);
		
	}
    
    public void drawDisplay(int c,int e,int g){
    	
    	
    	G.drawString("Time Remaining :"+c, 20, 620);
    	G.drawString("Points :"+e, 200, 620);
    	G.drawString("Level :"+g, 420, 620);
    	
    }
    
    
	

	public static int getxPatrol() {
		return xPatrol;
	}

	public static void setxPatrol(int xPatrol) {
		GraphicsPaintVisitor.xPatrol = xPatrol;
	}

	public static int getyPatrol() {
		return yPatrol;
	}

	public static void setyPatrol(int yPatrol) {
		GraphicsPaintVisitor.yPatrol = yPatrol;
	}

	
}
