public class Weapon extends Obj{
	
	
	//ATTRIBUTES
	public final int VALUE;
	
	
	//CONSTRUCTORS
	public Weapon(String name, int val) {
		super(name);
		this.VALUE = val;
	}
	
	@Override
	public void use(Hero h) {
		if(h.getPlace().getEnemies().size()>0){
			
			
			//TODO hit enemy
			
			
			//h.getPlace().getEnemies().forEach();
		}
	}
	
	@Override
	public void look() throws InterruptedException {
		Game.printLetterByLetter("Club");
	}
	//METHODS
	
	
	
	//getter
	
	
	//setter
	
	
	
	//printer
}
