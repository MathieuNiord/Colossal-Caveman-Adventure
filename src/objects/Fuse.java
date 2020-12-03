package objects;

import characters.*;
import others.*;

public class Fuse extends Obj {

	
	// ***** CONSTRUCTOR *****

	public Fuse(String name) {
		super(name);
	}


	// ***** METHODS *****

	
	// === COMMANDS ===

	@Override
	public void look() {
		Game.printLetterByLetter(Script.FUSE_DESCRIPT);
	}

	@Override
	public void use(Hero h) {
		System.out.println("Use this item with something else...");
	}
	
	@Override
	public void use(Hero h, String s) {
		if(h.getPlace().getItems().containsKey(s)){
			h.getPlace().getItems().get(s).use(h);
		}
	}
	
}
