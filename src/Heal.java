public class Heal extends Obj {
	
	//ATTRIBUTES
	public final int VALUE;
	
	
	//CONSTRUCTORS
	public Heal(String name, int val) {
		super(name);
		this.VALUE = val;
	}
	
	//METHODS
	
	
	
	//getter
	
	
	
	//setter
	
	
	
	//printer
	
	
	@Override
	public void use(Hero h) {
		h.setImmunised();
	}
	
	
	@Override
	public String toString() {
		return super.toString() + ",Value : " + this.VALUE;
	}
}
