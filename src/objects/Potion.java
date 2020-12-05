package objects;

import characters.*;
import others.*;

public class Potion extends Obj {

	
	// ***** CONSTRUCTOR *****

	public Potion(String name) {
		super(name);
	}

	
	// ***** METHODS *****
	

	// === COMMANDS ===

	@Override
	public void look()  {
		Game.printLetterByLetter(Script.POTION_DESCRIPT, Script.DEFAULT_NARRATOR);
	}

	@Override
	public void use(Hero h) {
		h.setImmunised();
		Game.printLetterByLetter("I don't know what was in this solution but you no longer have a nose." +
				"\nFortunately you are an athlete and a freediving champion. You should be immune now.\n", Script.DEFAULT_NARRATOR);
		h.getObjs().remove(Script.DEFAULT_POTION_NAME);
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this potion with something else\n", Script.DEFAULT_NARRATOR);
		
	}
	
}
