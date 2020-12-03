package Objects;

import Characters.*;
import Others.*;
import Interfaces.*;

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
	public void take(Hero h) throws InterruptedException {
		Game.printLetterByLetter("You successfully took the object !\n");
		h.getObjs().put(this.NAME,this);
		h.getPlace().getItems().remove(this.NAME);
	}
	
	@Override
	public void use(Hero h,String s) {
		System.out.println("You cannot combine those object together");
	}


	// === DISPLAY ===
	
	@Override
	public String toString() {
		return this.NAME;
	}
	
}
