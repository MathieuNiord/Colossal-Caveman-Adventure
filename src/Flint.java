public class Flint extends Obj {
	
	
	
	
	// ***** CONSTANTS *****
	
	// ***** ATTRIBUTES *****
	
	// ***** CONSTRUCTORS *****
	
	public Flint(String name) {
		super(name);
	}
	
	// ***** METHODS *****
	@Override
	public void use(Hero h) {
		if(h.getPlace().getName().equals("Mortuary")){
			if(h.getObjs().containsKey("Stick")){
				h.getObjs().remove("Stick");
				h.getObjs().remove("Flint");
				FiredStick firedStick = new FiredStick("FiredStick");
				h.getObjs().put(firedStick.name,firedStick);
				System.out.println("With your knowledge of caveman," +
						"\nyou managed to create fire with your flint and your stick a firedstick." +
						"\nMaybe he is useful in this room");
			}
		}
		else{
			System.out.println("Maybe you should use it in the right Room...");
			
		}
	}
	// Getter
	
	
	
	// Setter
	
	
	
	// Display
}
