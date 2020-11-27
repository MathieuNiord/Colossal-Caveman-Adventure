public class Animal  {
	// ***** CONSTANTS *****
	
	// ***** ATTRIBUTES *****
	public final String NAME;
	
	//This attribut is used for dialog
	public final int beschLevel;
	
	// ***** CONSTRUCTORS *****
	
	public Animal(String name, int bLevel){
		
		this.NAME = name;
		this.beschLevel=bLevel;
		
	}
	
	// ***** METHODS *****

	public void talk(Hero h){
		
		/*If the Bescherelle level of the hero is egal or higher than
		the Bescherelle level needed to talk with this animal*/
		if(h.getBLevel()>=beschLevel){
			
			System.out.println("Dialog with besch");
			
		}
		else {
			
			System.out.println("Dialog without besch");
			
		}
	}
	
	// Getter
	
	
	
	// Setter
	
	
	
	// Display
	@Override
	public String toString() {
		//Return the name of the animal
		return this.NAME;
	}
}

