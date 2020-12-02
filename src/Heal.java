public class Heal extends Obj {
	
	//ATTRIBUTES
	
	
	//CONSTRUCTORS
	public Heal(String name) {
		super(name);
	}
	
	//METHODS
	
	
	
	//getter
	
	
	
	//setter
	@Override
	public void use(Hero h) {
		//TODO message
		h.setImmunised();
		h.getObjs().remove("Potion");
	}
	
	
	//printer
	@Override
	public void look() throws InterruptedException {
		Game.printLetterByLetter(Script.FLINT_DESCRIPT);
	}
	
	
	
	
	@Override
	public String toString() {
		return super.toString();
	}
}
