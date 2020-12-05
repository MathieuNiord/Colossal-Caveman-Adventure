package objects;

import characters.*;
import interfaces.*;
import others.Game;
import others.Script;

public abstract class Obj implements Lookable, Usable, Takable {


	// ***** ATTRIBUTES *****

	public final String NAME;


	// ***** CONSTRUCTOR *****

	public Obj(String name) {
		this.NAME = name;
	}


	// ***** METHODS *****


	// === COMMANDS ===
	
	@Override
	public void take(Hero h) {
		Game.printLetterByLetter("You successfully took the object !\n", Script.DEFAULT_NARRATOR);
		h.getObjs().put(this.NAME,this);
		h.getPlace().getItems().remove(this.NAME);
	}

	// === DISPLAY ===
	
	@Override
	public String toString() {
		return this.NAME;
	}
	
}
