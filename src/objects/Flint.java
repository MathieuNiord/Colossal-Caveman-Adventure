package objects;

import characters.*;
import others.*;

public class Flint extends Obj {
	
	
	// ***** CONSTRUCTOR *****
	
	public Flint(String name) {
		super(name);
	}
	
	
	// ***** METHODS *****
	
	
	// === COMMANDS ===
	
	
	@Override
	public void look() {
		Game.printLetterByLetter(Script.FLINT_DESCRIPT);
	}
	
	@Override
	public void use(Hero h) {System.out.println("Use this item for something else...");}
	
	@Override
	public void use(Hero h,String s) {
		if(s.equals("Stick")){
			if(h.getPlace().getName().equals("Mortuary")){
				if(h.getObjs().containsKey(s)){
					h.getObjs().remove(s);
					h.getObjs().remove("Flint");
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
