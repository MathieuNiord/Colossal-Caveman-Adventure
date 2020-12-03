package characters;

import others.*;
import interfaces.*;

public class Animal implements Lookable {

	// ***** ATTRIBUTES *****
	public final String NAME;
	
	//This attribute is used for dialog
	public final int beschLevel;
	public final String noBeschDialog;
	public final String beschDialog;
	public final String description;


	// ***** CONSTRUCTORS *****
	
	public Animal(String name, int bLevel,String noBeschDialog,String beschDialog,String desc){
		
		this.NAME = name;
		this.beschLevel=bLevel;
		this.beschDialog = beschDialog;
		this.noBeschDialog = noBeschDialog;
		this.description = desc;
		
	}


	// ***** METHODS *****

	// === DISPLAY ===

	@Override
	public String toString() {
		//Return the name of the animal
		return this.NAME;
	}

	// === COMMANDS ===

	public void talk(Hero h) throws InterruptedException {

		/*If the Objects.Bescherelle level of the hero is egal or higher than
		the Objects.Bescherelle level needed to talk with this animal*/
		if(h.getBLevel()>=beschLevel){
			Game.printLetterByLetter(this.beschDialog);
		}
		else {
			Game.printLetterByLetter(this.noBeschDialog);
		}
	}

	public void look() throws InterruptedException {
		Game.printLetterByLetter(this.description);
	}
}

