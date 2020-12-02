import java.util.ArrayList;

public class Locker extends Obj{
	
	// ***** ATTRIBUTES *****
	private ArrayList<Obj> objs;
	
	public Locker(String name) {
		super(name);
		this.objs = new ArrayList<>();
	}
	
	// ***** CONSTRUCTOR *****


	// ***** METHODS *****

	// Getter

	public ArrayList<Obj> getObjs(){
		return this.objs;
	}
	
	
	// Setter

	public void addObj(Obj o){
		this.objs.add(o);
	}
	
	
	// Display
	
	@Override
	public String toString(){
		return this.getClass().getSimpleName();
	}
	
	@Override
	public void look() throws InterruptedException {
		Game.printLetterByLetter("You just looked in the locker and found :" + this.objs.toString());
	}
	
	@Override
	public void use(Hero h) {
		System.out.println("You cannot use a Locker STOOPID Caveman");
	}
}
