package objects;

import characters.*;
import others.*;

public class Weapon extends Obj{


	// ***** CONSTRUCTOR *****

	public Weapon(String name) {
		super(name);
	}


	// ***** METHODS *****


	// === COMMANDS ===

	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("Maybe you should find someone to hit with this " + this.NAME);
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this "+ this.NAME+" with something else\n");
	}
	
	@Override
	public void look() {
		Game.printLetterByLetter(Script.CLUB_DESCRIPT);
	}

}
