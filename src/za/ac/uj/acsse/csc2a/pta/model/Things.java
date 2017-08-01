package za.ac.uj.acsse.csc2a.pta.model;

public enum Things {

	/*
	 * various things which are to be found on layout
	 * use this enum to return particular thing
	 */
	ROCKS('-'),
	TREES('$'),
	HOUSE('|'),
	EMPTY('=');
	
	private final char typeThing;
	private Things(char typeThing){
		this.typeThing=typeThing;
	}
	
	public static Things getTypeThing(final char sign){
		for (Things thing:values())
		{
			if(thing.typeThing==sign)
			{
				return thing;
			}
		}
		return EMPTY;
	}
}
