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

	public void talk(int bLvl){}
	
	//getter
	
	
	
	//setter
	
	
	
	//printer
	
	@Override
	public String toString() {
		return this.NAME;
	}
}
