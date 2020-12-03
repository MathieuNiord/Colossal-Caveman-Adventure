package objects;

import characters.*;
import others.*;

public class Banana extends Obj {


	// ***** ATTRIBUTES *****

	private static int count = 0; //Used to give indication to the player


	// ***** CONSTRUCTOR *****
	
	public Banana(String name) {
		super(name);
	}


	// ***** METHODS *****


	// === COMMANDS ===

	@Override
	public void look() {
		Game.printLetterByLetter(Script.BANANA_DESCRIPT);
	}

	@Override
	public void use(Hero h) {
	
		if(h.getPlace().isContainsAnimals()) {

			Animal a = h.getPlace().getAnimals().get("Monkey");

			if (a != null && !(a instanceof Monkey))
				throw new IllegalStateException("Monkey expected but " + a.getClass() + " found: " + a);
			Monkey m = (Monkey) a;

			m.setUnHungry();
			Game.printLetterByLetter("You give the banana to the Monkey !");
		}
		else {
			count++;
			if (count < 3) {
				Game.printLetterByLetter("I think you should keep this Banana for somebody...");
			}
			else {
				Game.printLetterByLetter("I think you should go talk to the monkey...");
			}
		}
	}
	
	@Override
	public void use(Hero h, String s) {
	
	}
	
}
