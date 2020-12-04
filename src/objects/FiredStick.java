package objects;

import characters.*;
import others.Game;

public class FiredStick extends Obj {


	// ***** CONSTRUCTOR *****

	public FiredStick(String name) {
		super(name);
	}


	// ***** METHODS *****
	
	
	// === COMMANDS ===

	@Override
	public void look(){
	}

	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("Maybe there is something burnable somewhere in this room...\n");
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this "+ this.NAME+" with something else\n");
	}
	
}
