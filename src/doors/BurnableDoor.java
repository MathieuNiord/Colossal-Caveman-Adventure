package doors;

import characters.*;
import others.*;

public class BurnableDoor extends LockableDoor{
	
	// ***** CONSTRUCTOR *****

	public BurnableDoor(Place p1, Place p2) {
		super(p1, p2);
	}


	// ***** METHODS *****

	@Override
	public void cross(Hero hero, String s){
		s = s.toLowerCase();
		if(!this.isUnlock()){
			if(hero.getObjs().containsKey(Script.DEFAULT_FIREDSTICK_NAME)){ // If the hero has the Fired stick in his inventory
				Game.printLetterByLetter("Congrats ! You can now pass !\n", Script.DEFAULT_NARRATOR);
				this.unlock();
				this.open();
				hero.getObjs().remove(Script.DEFAULT_FIREDSTICK_NAME);
			}
			else{
				Game.printLetterByLetter("Is it a tunnel ? There are too many spiderwebs for you to borrow. Maybe by setting it on fire ...\n", Script.DEFAULT_NARRATOR);
			}
		}
		if(this.isUnlock()){
			hero.setPlace(this.getPlaces().get(s));
		}
	}

}
