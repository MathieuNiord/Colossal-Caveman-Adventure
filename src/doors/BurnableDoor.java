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
			if(hero.getObjs().containsKey(Script.DEFAULT_FIREDSTICK_NAME)){ // If the hero has the Firedstick
				System.out.println("You burned the door !" +
						"\nYou are now in the Archives-room");
				this.unlock();
				this.open();
				hero.getObjs().remove(Script.DEFAULT_FIREDSTICK_NAME);
			}
			else{
				System.out.println("This door looks very dry," +
						"\nMaybe you can do something here with your items");
			}
		}
		if(this.isUnlock()){
			hero.setPlace(this.getPlaces().get(s));
		}
	}

}
