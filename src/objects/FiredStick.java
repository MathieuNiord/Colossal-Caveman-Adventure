package objects;

import characters.*;
import others.Game;
import others.Script;

public class FiredStick extends Obj {


	// ***** CONSTRUCTOR *****

	public FiredStick(String name) {
		super(name);
	}


	// ***** METHODS *****
	
	
	// === COMMANDS ===

	@Override
	public void look(){
		Game.printLetterByLetter(Script.FIRED_STICK_DESCRIPT, Script.DEFAULT_NARRATOR);
	}

	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("Maybe there is something burnable somewhere in this Laboratory...\n", Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this "+ this.NAME+" with something else\n", Script.DEFAULT_NARRATOR);
	}
	
}
