import java.util.HashMap;

public class Door implements Crossable {

	// ***** ATTRIBUTES *****

	protected boolean open;
	private final HashMap<String, Place> places;

	// ***** CONSTRUCTORS *****

	Door(Place place){
		this.open = true;
		this.places = new HashMap<>();
		this.places.put(place.getName(), place);
	}

	Door(Place p1, Place p2){
		this.open = true;
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

	//Other

	public void cross(Hero hero, String s){
		if(this.isOpen()){
			hero.setPlace(this.getPlaces().get(s));     //Si c'est ouvert on peut passer
		}
	}
	
	public void look() {
	}
	
	// Display

	/*public String toString(){
		if (this.open) {
			return getClass().getSimpleName() + " is open";
		}
		else{
			return getClass().getSimpleName() + " is closed";
		}
	}*/
}