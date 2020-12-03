package doors;

import characters.*;
import others.*;

public class BurnableDoor extends LockableDoor{
	
	// ***** CONSTRUCTOR *****

	public BurnableDoor(Place p1) {
		super(p1);
	}


	// ***** METHODS *****

	@Override
	public void cross(Hero hero, String s){
		if(!this.isUnlock()){
			if(hero.getObjs().containsKey("FiredStick")){
				System.out.println("You burned the door !" +
						"\nYou are now in the Archives-room");
				this.unlock();
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
