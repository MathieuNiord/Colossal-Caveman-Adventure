public class Banana extends Obj {
	
	
	
	
	// ***** CONSTANTS *****
	
	// ***** ATTRIBUTES *****
	private static int count = 0;
	// ***** CONSTRUCTORS *****
	
	public Banana(String name) {
		super(name);
	}
	
	// ***** METHODS *****
	@Override
	public void use(Hero h) {
		count++;
		if(count<3){
			System.out.println("I think you should keep this Banana for somebody...");
		}
		else{
			System.out.println("I think you shoud go talk to the monkey");
			
		}
	}
	// Getter
	
	
	
	// Setter
	
	
	
	// Display
}
