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
import za.ac.uj.acsse.csc2a.pta.model.GameUpdate;
import za.ac.uj.acsse.csc2a.pta.model.Person;


public class CrimeFrame extends JFrame {

	
	/*
	 * Adds all components of panel
	 * and ensure that they are displayed in frame
	 */
	CrimePanel pnl=null;
	private ArrayList<Person>ppl=new ArrayList<Person>();
	private GameUpdate game=new GameUpdate();
    private JMenuBar menuBar;
    private JMenu fileInstructions;
    private JMenuItem fileNew;   
	public ReadPeople read=new ReadPeople();
   
    boolean local=false;
    public static Timer t ;
    
	public CrimeFrame() {
		setTitle("GameOfCriminals");
		pnl=new CrimePanel(read.readThingsLayout("data/things.lvl"));
		

		//loading and adding instructions strip 
		menuBar = new JMenuBar();
	    fileInstructions = new JMenu("Instructions");
	    fileNew = new JMenuItem("Read Instructions");
	
		add(menuBar,BorderLayout.NORTH);
		menuBar.add(fileInstructions);
	    fileInstructions.add(fileNew);
	   
	   
	   
	   //timer being used to update level
	     pnl.time = new Timer(1,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 
				if (pnl.points<60){
					local=false;
					
				}
				else if (pnl.points >= 60)
				{
					local = true;
					
				}
				
				
				   if (local==false){
				    	//adding level1
				    	 CrimePanel.person.clear();
						 CrimePanel.person.addAll(read.readPeopleType("data/level1.txt"));
						 ((Timer)e.getSource()).stop();
				     }
				     else if(local){
				    	 //adding level2
				    	 CrimePanel.person.clear();
						 CrimePanel.person.addAll(read.readPeopleType("data/level2.txt"));	
					   	repaint();
						pnl.time.stop();
				     }
			}
		});
	     
	     
	     //invoking instructions for user
	    fileNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
						 
				 JOptionPane.showMessageDialog(null, "This is a single game player.You are the player at the top left "
				 		+ "of screen  and intially you are given 50 Free points. \n Objective of game is for"
						 +" you to collect points from house at the bottom of RIGHT CORNER until you reach 100 points \n This is done by moving player around "+
				 		" using four arrow keys. There are police and soldiers who are patroling \n if you bump "
				 		+"into them you lose points and if you bump into main patroler you lose game");
			}
		});
	     
	   
		 pnl.repaint();
	     pnl.setThis(ppl);
	     add(pnl);
	    
		

			
			 
	
		
	     
	    }
	


	
	public void setThis(ArrayList<Person> ppl){
		  pnl.setThis(ppl);
		  repaint();
		 
		}
	
	}

