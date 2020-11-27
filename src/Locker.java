import java.util.ArrayList;

public class Locker{
	
	// ***** ATTRIBUTES *****
	private ArrayList<Obj> objs;
	
	// ***** CONSTRUCTOR *****
	
	public Locker() {
		this.objs = new ArrayList<>();
	}

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
}
