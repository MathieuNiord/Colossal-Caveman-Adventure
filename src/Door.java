import java.util.ArrayList;
import java.util.HashMap;

public class Door {

	// ***** ATTRIBUTES *****

	private boolean open = false;
	private HashMap<String, Place> places;

	// ***** CONSTRUCTORS *****

	Door(Place place){
		this.places = new HashMap<>();
		this.places.put(place.getName(), place);
		//System.out.println("You create a basic door")
	}

	Door(Place p1, Place p2){
		this.places = new HashMap<>();
		this.places.put(p1.getName(),p1);
		this.places.put(p2.getName(), p2);
	}

	// ***** METHODS *****

	// Getter

	public boolean isOpen(){
		return this.open;
	}

	public HashMap<String, Place> getPlaces(){
		return this.places;
	}

	// Setter
	public void open(){
		this.open = true;
		if(!this.getClass().getSimpleName().equals("DestructableDoor")){
			System.out.println("You opened the door, u gat dat hommy !");
		}
	}

	public void close(){
		this.open = false;
	}

	// Display

	public String toString(){
		if (this.open) {
			return getClass().getSimpleName() + " is open";
		}
		else{
			return getClass().getSimpleName() + " is closed";
		}
	}

	public static void printDoorList(ArrayList<? extends Door> doors){
		for(Door d : doors) {
			System.out.println(d);
		}
	}
}