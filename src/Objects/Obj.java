package Objects;

import Characters.*;
import Others.*;
import Interfaces.*;

public abstract class Obj implements Lookable, Usable, Takable {
	
	//ATTRIBUTES
	public final String NAME;
	
	//CONSTRUCTORS
	public Obj(String name) {
		this.NAME = name;
	}
	//METHODS
	
	@Override
	public void take(Hero h) throws InterruptedException {
		Game.printLetterByLetter("You successfully took the object !");
		h.getObjs().put(this.NAME,this);
		h.getPlace().getItems().remove(this.NAME);
	}
	//getter

	//setter
	
	//printer
	
	@Override
	public String toString() {
		return this.NAME;
	}
	
}
