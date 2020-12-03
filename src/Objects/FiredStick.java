package Objects;

import Characters.*;

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
		System.out.println("Use this item for something else...");
	}

}
