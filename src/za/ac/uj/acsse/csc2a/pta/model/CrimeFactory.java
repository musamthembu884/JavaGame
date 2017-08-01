package za.ac.uj.acsse.csc2a.pta.model;

public abstract class CrimeFactory {

	/*
	 * Abstract factory which works from super-factory
	 * to create other factories such as ProducePolice and ProduceSoldier
	 */
	public abstract CrimeProduct ProducePolice(String name, int iD, String colorCode, int xValue,
			int yValue, String position);
	public abstract CrimeProduct ProduceSoldier(String name, int iD, String colorCode, int xValue,
			int yValue, String guntype);
	
}
