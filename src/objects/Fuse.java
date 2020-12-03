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
		if(h.getPlace().getItems().containsKey("ElectricityMeter")){
			h.getPlace().getItems().get("ElectricityMeter").use(h);
		}
	}

}
