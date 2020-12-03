package objects;

import characters.*;
import others.*;

public class Stick extends Obj {

	
	// ***** CONSTRUCTOR *****
	
	public Stick(String name) {
		super(name);
	}


	// ***** METHODS *****


	// === COMMANDS ===
	
	@Override
	public void look() {
		Game.printLetterByLetter(Script.STICK_DESCRIPT);
	}
	
	@Override
	public void use(Hero h) {}

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
	
}

