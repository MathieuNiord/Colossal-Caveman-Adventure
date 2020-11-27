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
	
	public int getValue(){
		return this.VALUE;
	}
	
	
	//setter
	
	
	
	//printer
	
	
	@Override
	public String toString() {
		return super.toString() + ",Value : " + this.VALUE;
	}
}
