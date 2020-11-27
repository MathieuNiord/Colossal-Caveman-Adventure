public class Monkey extends Animal{
	
	// ***** CONSTANTS *****
	
	// ***** ATTRIBUTES *****
	
	private boolean hungry;
	
	// ***** CONSTRUCTORS *****
	
	public Monkey(String name, int bLevel) {
		super(name, bLevel);
		this.hungry = true;
	}
	
	// ***** METHODS *****
	
	// Getter
	
	
	
	// Setter
	
	
	
	// Display
	
	
	@Override
	public void talk(Hero h) {
		
		if(h.getObjs().containsKey("Banana")){
			h.getObjs().remove("Banana");
			this.hungry = false;
		}
		
		if(!this.hungry){
			super.talk(h);
		}
		else{
			System.out.println("Dialog when hungry");
		}
	}
}
