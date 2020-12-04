package doors;

import characters.*;
import others.*;

public class BurnableDoor extends LockableDoor{
	
	// ***** CONSTRUCTOR *****

	public BurnableDoor(Place p1, Place p2) {
		super(p1, null);
	}


	// ***** METHODS *****

	@Override
	public void cross(Hero hero, String s){
		if(!this.isUnlock()){
			if(hero.getObjs().containsKey("FiredStick")){ // If the hero has the Firestick
				System.out.println("You burned the door !" +
						"\nYou are now in the Archives-room");
				this.unlock();
				this.open();
				hero.getObjs().remove("FiredStick");
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
