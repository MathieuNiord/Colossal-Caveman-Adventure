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
	public void use(Hero h) {}
	
	@Override
	public void look() throws InterruptedException {
		Game.printLetterByLetter("Club");
	}

}
