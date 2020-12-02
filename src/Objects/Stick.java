package Objects;

import Characters.*;
import Others.*;

public class Stick extends Obj {
	
	
	
	
	// ***** CONSTANTS *****
	
	// ***** ATTRIBUTES *****
	
	// ***** CONSTRUCTORS *****
	
	public Stick(String name) {
		super(name);
	}
	
	// ***** METHODS *****
	@Override
	public void use(Hero h) {
		if(h.getPlace().getName().equals("Mortuary")){
			if(h.getObjs().containsKey("Flint")){
				h.getObjs().remove("Stick");
				h.getObjs().remove("Flint");
				FiredStick firedStick = new FiredStick("FiredStick");
				h.getObjs().put(firedStick.NAME,firedStick);
			}
		}
		else{
			System.out.println("Maybe you should use it in the right Room...");
			
		}
	}
	// Getter
	
	
	
	// Setter
	
	
	
	// Display
	@Override
	public void look() throws InterruptedException {
		Game.printLetterByLetter(Script.STICK_DESCRIPT);
	}
}
