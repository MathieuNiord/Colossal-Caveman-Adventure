package objects;

import characters.*;
import others.*;

public class Bescherelle extends Obj{


	// ***** CONSTRUCTOR *****

	public Bescherelle(String name) {
		super(name);
	}


	// ***** METHODS *****


	// === COMMANDS ===
	
	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("NO PLEASE DON'T EAT THIS " + this.NAME.toUpperCase() + "\n", Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("NO PLEASE DON'T EAT THIS " + this.NAME.toUpperCase() + "\n", Script.DEFAULT_NARRATOR);
		
	}
	
	@Override
	public void take(Hero h)  {
		h.increaseBescherelle();
		super.take(h);
	}
	
	@Override
	public void look() {
		Game.printLetterByLetter(Script.BESCH_DESCRIPT, Script.DEFAULT_NARRATOR);
	}

}
