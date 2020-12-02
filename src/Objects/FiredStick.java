package Objects;

import Characters.*;

public class FiredStick extends Obj {
	
	
	
	
	
	// ***** CONSTANTS *****
	
	// ***** ATTRIBUTES *****
	
	// ***** CONSTRUCTORS *****
	public FiredStick(String name) {
		super(name);
	}
	// ***** METHODS *****
	@Override
	public void use(Hero h) {
		System.out.println("Use this item for something else...");
	}
	// Getter
	
	
	
	// Setter
	
	
	
	// Display
	@Override
	public void look() throws InterruptedException {
	}
}
