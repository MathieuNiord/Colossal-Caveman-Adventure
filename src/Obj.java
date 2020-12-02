public abstract class Obj implements Lookable,Usable,Takable{
	
	//ATTRIBUTES
	public final String name;
	
	//CONSTRUCTORS
	public Obj(String name) {
		this.name = name;
	}
	//METHODS
	
	@Override
	public void take(Hero h) throws InterruptedException {
		Game.printLetterByLetter("You successfully took the object !");
		h.getObjs().put(this.name,this);
		h.getPlace().getItems().remove(this.name);
	}
	//getter

	//setter
	
	//printer
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
