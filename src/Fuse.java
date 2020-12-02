public class Fuse extends Obj {
	
	// ***** CONSTANTS *****
	
	// ***** ATTRIBUTES *****
	
	// ***** CONSTRUCTORS *****
	public Fuse(String name) {
		super(name);
	}
	// ***** METHODS *****
	@Override
	public void use(Hero h) {
		if(h.getPlace().getItems().containsKey("ElectricityMeter")){
			h.getPlace().getItems().get("ElectricityMeter").use(h);
		}
	}
	
	
	// Getter
	
	
	
	// Setter
	
	
	
	// Display
	@Override
	public void look() throws InterruptedException {
		Game.printLetterByLetter(Script.FUSE_DESCRIPT);
	}
}
