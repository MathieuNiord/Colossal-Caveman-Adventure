package objects;

import characters.*;
import others.*;

public class Banana extends Obj {


	// ***** ATTRIBUTES *****

	private static int count = 0;


	// ***** CONSTRUCTOR *****
	
	public Banana(String name) {
		super(name);
	}


	// ***** METHODS *****


	// === COMMANDS ===

	@Override
	public void look() {
		Game.printLetterByLetter(Script.BANANA_DESCRIPT);
	}

	@Override
	public void use(Hero h) {
		if (h.getPlace().getName().equals("Experiments room")) {
			if(h.getPlace().isContainsAnimals()) {

				Animal a = h.getPlace().getAnimals().get("Monkey");

				if (a != null && !(a instanceof Monkey))
					throw new IllegalStateException("Monkey expected but " + a.getClass() + " found: " + a);
				Monkey m = (Monkey) a;

				m.setUnHungry();
				System.out.println("You give the banana to the Monkey MY BOUGA BOUGA !");
			}
		} else {
			count++;
			if (count < 3) {
				System.out.println("I think you should keep this Objects.Banana for somebody...");
			} else {
				System.out.println("I think you shoud go talk to the monkey...");

			}
		}
	}
	
	@Override
	public void use(Hero h, String s) {
	
	}
	
}