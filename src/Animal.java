public class Animal  {
	// ***** CONSTANTS *****
	
	// ***** ATTRIBUTES *****
	public final String NAME;
	
	//This attribut is used for dialog
	public final int beschLevel;
	public final String noBeschDialog;
	public final String beschDialog;
	// ***** CONSTRUCTORS *****
	
	public Animal(String name, int bLevel,String noBeschDialog,String beschDialog){
		
		this.NAME = name;
		this.beschLevel=bLevel;
		this.beschDialog = beschDialog;
		this.noBeschDialog = noBeschDialog;
		
	}
	
	// ***** METHODS *****

	public void talk(Hero h) throws InterruptedException {
		
		/*If the Bescherelle level of the hero is egal or higher than
		the Bescherelle level needed to talk with this animal*/
		if(h.getBLevel()>=beschLevel){
			Game.printLetterByLetter(this.beschDialog);
		}
		else {
			Game.printLetterByLetter(this.noBeschDialog);
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

