package objects;

import characters.*;

public abstract class Poster extends Obj {

	// ***** ATTRIBUTES *****
	
	public final Hero HERO;
	
	// ***** CONSTRUCTORS *****
	
	public Poster(String name, Hero hero) {
		super(name);
		this.HERO = hero;
	}
	
	// ***** METHODS *****
	
	
	// === COMMANDS ===

}
