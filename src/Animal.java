public class Animal  {
	
	//ATTRIBUTES
	public final String NAME;
	public final int beschLevel;
	//CONSTRUCTORS
	
	public Animal(String name, int bLevel){
		
		this.NAME = name;
		this.beschLevel=bLevel;
		
	}
	
	//METHODS

	public void talk(Hero h){
		if(h.getBLevel()>=beschLevel){
			System.out.print("Dialog with besch");
		}
		else {
			System.out.print("Dialog without besch");
		}
	}
	
	//getter
	
	
	
	//setter
	
	
	
	//printer
	
	@Override
	public String toString() {
		return this.NAME;
	}
}
