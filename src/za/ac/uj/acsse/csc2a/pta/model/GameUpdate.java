package za.ac.uj.acsse.csc2a.pta.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Timer;

public class GameUpdate {
	
   
   /*Class that updates scoreboard of game
    * Uses points to continously update game
    */
    private int points;
    
    //reading points from textfile
    public int readPoints(String fileName){
    	File file=new File(fileName);
    	Scanner scan=null;
    	try{
    		scan=new Scanner(file);
    		String line="";
    		while(scan.hasNext()){
    			line=scan.nextLine();
    			points=Integer.parseInt(line);
    		}
    	}
    		catch(FileNotFoundException ex){
        		ex.printStackTrace();
        	}
    		finally{
    			if(scan!=null){
    				scan.close();
    			}
    		}
    	return points;
    	}
    	
    	
    	
    
	//writing point to textfile
	public void writePoints(String file,int point){
		PrintWriter write = null;
		try{
		write=	new PrintWriter(file);
			write.println(point);
			
		}
		catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
		write.close();
	}

	
	
	


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


}
