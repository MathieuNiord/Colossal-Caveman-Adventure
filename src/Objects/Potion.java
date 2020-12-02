package Objects;

import Characters.*;
import Others.*;

public class Potion extends Obj {
	
	//ATTRIBUTES
	
	
	//CONSTRUCTORS
	public Potion(String name) {
		super(name);
	}
	
	//METHODS
	
	
	
	//getter
	
	
	
	//setter
	@Override
	public void use(Hero h) {
		h.setImmunised();
		System.out.println("I don't know what was in this solution but you no longer have a nose. Fortunately you are an athlete and a freediving champion. You should be immune now.");
		h.getObjs().remove("Potion");
	}
	
	
	//printer
	//@Override
	public void look() throws InterruptedException {
		Game.printLetterByLetter(Script.FLINT_DESCRIPT);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
