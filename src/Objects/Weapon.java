package Objects;

import Characters.*;
import Others.*;

public class Weapon extends Obj{
	
	//CONSTRUCTORS
	public Weapon(String name) {
		super(name);
	}
	
	@Override
	public void use(Hero h) {
		if(h.getPlace().getEnemies() != null){
			
			
			//TODO hit enemy
			
			
			//h.getPlace().getEnemies().forEach();
		}
	}
	
	@Override
	public void look() throws InterruptedException {
		Game.printLetterByLetter("Club");
	}
	//METHODS
	
	
	
	//getter
	
	
	//setter
	
	
	
	//printer
}
