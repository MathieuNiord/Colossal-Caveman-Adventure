package objects;

import characters.*;
import others.*;

public class Banana extends Obj {

	
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
	public void use(Hero h) {Game.printLetterByLetter("Maybe someone is interested for this " +this.NAME+"...\n");}
	
	@Override
	public void use(Hero h, String s) {
		this.use(h);
	}
	
}
