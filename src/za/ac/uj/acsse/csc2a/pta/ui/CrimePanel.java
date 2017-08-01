package za.ac.uj.acsse.csc2a.pta.ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import src.za.ac.uj.acsse.csc2a.pta.file.ReadPeople;
import sun.reflect.generics.visitor.Visitor;
import za.ac.uj.acsse.csc2a.pta.model.DesignThings;
import za.ac.uj.acsse.csc2a.pta.model.GameUpdate;
import za.ac.uj.acsse.csc2a.pta.model.Person;
import za.ac.uj.acsse.csc2a.pta.model.Police;

public class CrimePanel extends JPanel implements ActionListener,KeyListener{
	
	/*
	 * display the people(police and soldier)
	 * logic of game
	 */
	//time to start the entire fame
	public Timer time=new Timer(10,this);
	//player coordinates 
	private int moveX=0;
	private int moveY=0;
	private int x=0;
	private int y=0;
	private static int size=50;
	private int moveDanger=10;
	private int xh=570;
	private int yh=500;
	

	GraphicsPaintVisitor visitor=new GraphicsPaintVisitor();
	public static ArrayList<Person>person=new ArrayList<Person>();
	private DesignThings design;
	private static GameUpdate game=new GameUpdate();
	int localX=visitor.getxPatrol();
	int localY=visitor.getyPatrol();
	public int life;
	public  int cnt;
	private int stage=0;
	private int difference=4000-cnt;
	//reading score from text file
	public  int points=game.readPoints("data/score.txt");
    
	
	//intialize timer and set out the default layout
	public CrimePanel(DesignThings design){
		time.start();
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		this.design=design;
		Dimension d = new Dimension(350,350);
		this.setSize(d);
		this.setPreferredSize(d);
		points=50;
		game.writePoints("score.txt", points);
		
	}
	
	
	

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		visitor.setG(g);
		//using the design pattern to draw specific person
	    design.accept(visitor);
		for (Person p:person){
			p.accept(visitor);
			
		}
		//drawing player onto canvas and updating life and score board
		visitor.drawPlayer(x, y);
	    visitor.drawPatrol(localX,localY);
	    visitor.drawDisplay(difference,points,stage);
		
	}

	//formula to check radius of player and persons 
	private boolean formula(int x1,int x2,int y1,int y2){
		boolean mathFloor=false;
		double distance=Math.sqrt(((x1-x2)*(x1-x2)+((y1-y2)*(y1-y2))));
		if (distance < size )
		{
			 mathFloor=true;
		}
		return mathFloor;
	}
	public void actionPerformed(ActionEvent e) {
	/*
	 * entire logic of game 
	 * is in this method
	 */
		
		//checking bounds
		if(x<0){
			x=0;
			moveX=0;
		}
		if(x>540){
			moveX=0;
			x=540;
		}
		
		if(y<0){
			y=0;
			moveY=0;
		}
		if(y>520){
			moveY=0;
			y=520;
		}
		
		if(localX < 50 || localX>500){
			
			moveDanger=-moveDanger;
		}
		
		//checking accidents
		if (formula(localX,x,localY,y)==true){
			 size=0;
			 moveDanger=0;
			 
			 JOptionPane.showMessageDialog(null, "Accident- Game Over");
			  time.stop();
			  setVisible(false);
			
			 
		}
		
		//updating score
		if (formula(xh,x,yh,y)==true){
			x=0;
			y=0;
			points=points+10;
		    game.writePoints("score.txt",points);
			
		}	
		
		//decreasing score
		for (int r=0;r<person.size();r++){
			if (formula(person.get(r).getxValue(),x,person.get(r).getyValue(),y)==true){
				points=points-10;
				x=0;
				y=0;
			}	
		}
		
		//indicate level 1
		if (points<=50 ){
			
			time.start();
			stage=1;
			
			
		}
		
		//indicate level 2
		else if(points == 60)
		{
			
			time.start();
			stage=2;
			

		}
		
		//indicate game has been won
		else if (points ==100){
			
			JOptionPane.showMessageDialog(null, "Game Won");
			time.stop();
			setVisible(false);
		}
		
 
		
		//updating player movement
		x=x+moveX;
		y=y+moveY;
		localX=localX+moveDanger;
		
		/*
		 * indicating game is over
		 */
		if(difference==0 ){
			JOptionPane.showMessageDialog(null, "Game Over-Time UP");
			time.stop();
			 setVisible(false);
		}
		else if(points==0){
			JOptionPane.showMessageDialog(null, "Game Over-Points Finished");
			time.stop();
			 setVisible(false);

		}
		
         difference--;
		repaint();
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// moving player around with keyboard
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_LEFT){
			moveX=-3;
			moveY=0;
		}
		if(key==KeyEvent.VK_UP){
			moveX=0;
			moveY=-3;
		}
		if(key==KeyEvent.VK_RIGHT){
			moveX=3;
			moveY=0;
		}
		if(key==KeyEvent.VK_DOWN){
			moveX=0;
			moveY=3;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		moveX=0;
	    moveY=0;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	//initializing array
	public void setThis(ArrayList<Person>person ){
		this.person=person;
	}
  
	
    
}
