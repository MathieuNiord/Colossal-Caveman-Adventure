package Objects;

import Characters.*;
import Others.Script;

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
	
	@Override
	public void look() throws InterruptedException {
		System.out.println(Script.DEFAULT_POSTER);
	}
	
	@Override
	public void take(Hero h) throws InterruptedException {}
	
	@Override
	public void use(Hero h) throws InterruptedException {}

}
