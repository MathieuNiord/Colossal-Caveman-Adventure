package doors;

import characters.*;
import others.*;

public abstract class LockableDoor extends Door {


	// ***** ATTRIBUTES *****

	private boolean lock;


	// ***** CONSTRUCTORS ****

	LockableDoor(Place p1, Place p2){
		super(p1, p2);
		this.open = false;
		this.lock = true;
	}


	// ***** METHODS *****


	// === GETTER ===

	public boolean isUnlock() {
		return !this.lock;
	}


	// === SETTER ===

	public void unlock() {
		this.lock = false;
	}

	@Override
	public void open() {
		if(!this.lock) {
			super.open();
		}
		else{
			System.out.print("Hmm Hmm...The door is locked buddy...\n");
		}
	}


	// === OTHER ===

	@Override
	public void cross(Hero hero, String s){
		s = s.toLowerCase();
		if(this.isUnlock()){
			hero.setPlace(this.getPlaces().get(s));     //Si c'est déverrouillé on peut passer
		}
	}

}
