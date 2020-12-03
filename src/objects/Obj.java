package objects;

import characters.*;
import interfaces.*;

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
		System.out.println("You successfully took the object !\n");
		h.getObjs().put(this.NAME,this);
		h.getPlace().getItems().remove(this.NAME);
	}

	// === DISPLAY ===
	
	@Override
	public String toString() {
		return this.NAME;
	}
	
}
