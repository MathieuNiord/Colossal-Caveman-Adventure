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
		Game.printLetterByLetter(Script.FLINT_DESCRIPT, Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("Use this item with something else...", Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h,String s) {
		if (s != null){
			s = s.toLowerCase();
			if(s.equals(Script.DEFAULT_STICK_NAME)){
				if(h.getObjs().containsKey(s)){
					h.getObjs().remove(s);
					h.getObjs().remove(this.NAME);
					FiredStick firedStick = new FiredStick(Script.DEFAULT_FIREDSTICK_NAME);
					h.getObjs().put(firedStick.NAME,firedStick);
					Game.printLetterByLetter("With your knowledge of caveman, you managed to create fire with your flint and your stick a fired stick.\n", Script.DEFAULT_NARRATOR);
				}
			}
			else{
				Game.printLetterByLetter("You cannot combine those objects together\n", Script.DEFAULT_NARRATOR);
			}
		}
	}

}
