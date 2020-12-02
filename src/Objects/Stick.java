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
	@Override
	public void use(Hero h,String s) {
		if(s.equals("Flint")){
			if(h.getPlace().getName().equals("Mortuary")){
				if(h.getObjs().containsKey(s)){
					h.getObjs().remove(s);
					h.getObjs().remove("Stick");
					FiredStick firedStick = new FiredStick("FiredStick");
					h.getObjs().put(firedStick.NAME,firedStick);
					System.out.println("With your knowledge of caveman," +
							"\nyou managed to create fire with your flint and your stick a firedstick." +
							"\nMaybe he is useful in this room");
				}
			}
			else{
				System.out.println("Maybe you should use it in the right Room...");
			}
		}
		else{
			System.out.println("You cannot combine those object together");
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
