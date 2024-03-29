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


	// ***** CONSTRUCTOR *****
	
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

	public void talk(Hero h) {
		/*If the Objects.Bescherelle level of the hero is egal or higher than
		the Objects.Bescherelle level needed to talk with this animal*/
		if(h.getBLevel()>=beschLevel){
			Game.printLetterByLetter(this.beschDialog, this.NAME);
		}
		else {
			Game.printLetterByLetter(this.noBeschDialog, this.NAME);
		}
	}

	
	public void look() {
		Game.printLetterByLetter(this.description, this.NAME);
	}
}

