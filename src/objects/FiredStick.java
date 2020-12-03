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
		Game.printLetterByLetter("Use this item for something else...");
	}
	
	@Override
	public void use(Hero h, String s) {
	
	}
	
}
