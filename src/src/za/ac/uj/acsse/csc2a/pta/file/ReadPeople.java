package src.za.ac.uj.acsse.csc2a.pta.file;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import za.ac.uj.acsse.csc2a.pta.model.CrimeFactory;
import za.ac.uj.acsse.csc2a.pta.model.DesignThings;
import za.ac.uj.acsse.csc2a.pta.model.Person;
import za.ac.uj.acsse.csc2a.pta.model.Police;
import za.ac.uj.acsse.csc2a.pta.model.ProduceProduct;
import za.ac.uj.acsse.csc2a.pta.model.Soldier;
import za.ac.uj.acsse.csc2a.pta.model.Things;

public class ReadPeople {

	/*
	 * Creating arrayList to read all the content of
	 * people from text file.
	 * 
	 */
	public  ArrayList<Person> readPeopleType(String filename){
		ArrayList<Person> person=new ArrayList<Person>();
		File file=new File(filename);
		Scanner scan=null;
		CrimeFactory factory=null;
		try{
			scan=new Scanner(file);
			String line="";
			while(scan.hasNext()){
				line=scan.nextLine();
				StringTokenizer token=new StringTokenizer(line," ");
				String Name=token.nextToken();
				int ID=Integer.parseInt(token.nextToken());
				String ColorCode=token.nextToken();
				int xValue=Integer.parseInt(token.nextToken());
				int yValue=Integer.parseInt(token.nextToken());
				String activity=token.nextToken();
			    Person normalPerson=null;
				factory=new ProduceProduct();
		//depending on type of person we can have a soldier or police
				switch(ColorCode)
				{
				case "BLUE":
					Police police=new Police(Name, ID, ColorCode, xValue, yValue, activity);
					
					person.add(police);
					break;
				case "RED":
					Soldier soldier=new Soldier(Name, ID, ColorCode, xValue, yValue, activity);
					
					person.add(soldier);
					break;
				default:
					break;
				}
					
				//person.add(normalPerson);
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
		
		
		return person;
	}
	
	/*
	 * Open and read layout of game
	 * Use the lvl file to check for various kinds of layouts */
	public static DesignThings readThingsLayout(String thingslayout){
		DesignThings things=null;
		Scanner scan=null;
		File file=new File(thingslayout);
		try{
			scan=new Scanner(file);
			String line="";
			line=scan.nextLine();
			StringTokenizer token=new StringTokenizer(line);
			int rows=Integer.parseInt(token.nextToken());
			int cols=Integer.parseInt(token.nextToken());
			Things [][] thing=new Things[rows][cols];
			int row=0;
			while(scan.hasNext()){
				line=scan.nextLine();
				for(int col=0;col<line.length();col++){
					thing[row][col]=Things.getTypeThing(line.charAt(col));
				}
				row++;
			}
			things=new DesignThings(thing);
		}
		catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
		finally{
			if(scan!=null){
				scan.close();
			}
		}
		return things;
	}
	
	
	
}
