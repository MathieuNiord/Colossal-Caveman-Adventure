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
		System.out.println("You cannot use a Bescherelle. STOOPID");
	}
	
	@Override
	public void use(Hero h, String s) {
	
	}
	
	@Override
	public void take(Hero h)  {
		h.increaseBescherelle();
		super.take(h);
	}
	
	@Override
	public void look() {
		Game.printLetterByLetter(Script.BESCH_DESCRIPT);
	}

}
