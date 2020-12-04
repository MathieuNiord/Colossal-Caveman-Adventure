package objects;

import characters.*;
import others.*;

public class ElectricityMeter extends Obj{
	

	// ***** ATTRIBUTES *****

	private boolean hasFuse;
	public final Place place;


	// ***** CONSTRUCTOR *****

	public ElectricityMeter(String name, Place p) {
		super(name);
		this.hasFuse = false;
		this.place = p;
	}


	// ***** METHODS *****

	// === GETTER ===
	
	public Place getPlace() {
		return this.place;
	}

	// === SETTER ===

	public void setHasFuse(){
		this.hasFuse=true;
	}
	
	
	// === COMMANDS ===

	@Override
	public void look() {
		if(!this.hasFuse){
			Game.printLetterByLetter(Script.ELECTRICMETER_MISSING_DESCRIPT);
		}
		else{
			Game.printLetterByLetter(Script.ELECTRICMETER_DESCRIPT);
		}
	}

	@Override
	public void take(Hero h) {
		Game.printLetterByLetter("You cannot take this Electric meter, it's too heavy for HOUGA BOUGA\n");
	}

	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("Use this item with something else...\n");
	}
	
	@Override
	public void use(Hero h, String s) {
		if(!this.hasFuse){
			
			if(s.equals(Script.DEFAULT_FUSE_NAME) && h.getObjs().containsKey(Script.DEFAULT_FUSE_NAME)){
				
				Game.printLetterByLetter("You just added the missing " + Script.DEFAULT_FUSE_NAME + "\n");
				
				h.getObjs().remove(Script.DEFAULT_FUSE_NAME);
				this.setHasFuse();
				
			}
			
		}
		if(this.hasFuse && !place.isEnlightened()){
			place.setEnlightened();
		}
		else{
			Game.printLetterByLetter("You've already placed the missing "+ Script.DEFAULT_FUSE_NAME +" !\n");
		}
	}
	
}
