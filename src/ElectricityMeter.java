public class ElectricityMeter extends Obj{
	
	
	// ***** CONSTANTS *****
	
	// ***** ATTRIBUTES *****
	private boolean hasFuse;
	public final Place place;
	// ***** CONSTRUCTORS *****
	public ElectricityMeter(String name,Place p) {
		super(name);
		this.hasFuse=false;
		this.place=p;
	}
	// ***** METHODS *****
	@Override
	public void use(Hero h) {
		if(h.getObjs().containsKey("Fuse")){
			System.out.println("You just added the missing fuse");
			h.getObjs().remove("Fuse");
			this.setHasFuse();
		}
		if(this.hasFuse && !place.isEnlightened()){
			place.switchEnlightened();
		}
		else{
			System.out.println("You've already placed the Fuse !");
		}
	}
	
	@Override
	public void take(Hero h) throws InterruptedException {
		Game.printLetterByLetter("You cannot take this Electric meter, it's too heavy for HOUGA BOUGA");
	}
	
	// Getter
	
	
	
	// Setter
	public void setHasFuse(){
		this.hasFuse=true;
	}
	
	
	// Display
	@Override
	public void look() throws InterruptedException {
		if(!this.hasFuse){
			Game.printLetterByLetter(Script.ELECTRICMETER_MISSING_DESCRIPT);
		}
		else{
			Game.printLetterByLetter(Script.ELECTRICMETER_DESCRIPT);
		}
	}
}
