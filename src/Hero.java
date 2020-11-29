import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hero {

	public final static int DEFAULT_HP = 100;
	public final static int DEFAULT_BESCHERELLE_LEVEL = 0;
	public final static int DEFAULT_KEY_LEVEL = 0;
	public final static boolean DEFAULT_IMMUNISED_VALUE = false;

	public final static String NAME = "Houga Bouga";


	// ***** ATTRIBUTES *****

	private final String PLAYERNAME;
	private int hp;
	private int keyLevel;
	private int lvlBescherelle;
	private boolean immunised;
	private Map<String, Obj> objs;
	private Place place;

	// ***** CONSTRUCTORS *****
	public Hero(String name, Place place) {

		this.PLAYERNAME = name;
		this.hp = DEFAULT_HP;
		this.keyLevel = DEFAULT_KEY_LEVEL;
		this.lvlBescherelle = DEFAULT_BESCHERELLE_LEVEL;
		this.immunised = DEFAULT_IMMUNISED_VALUE;
		this.objs = new HashMap<>();
		this.place = place;

	}


	// ***** METHODS *****


	// Getter

	public int getHP() {
		return this.hp;
	}

	public int getBLevel() {
		return this.lvlBescherelle;
	}

	public int getKeyLevel() {
		return this.keyLevel;
	}

	public boolean isImmun() {
		return this.immunised;
	}

	public String getPLAYERNAME() {
		return this.PLAYERNAME;
	}

	public Place getPlace() {
		return this.place;
	}
	
	public Map<String, Obj> getObjs(){
		return this.objs;
	}

	// Setter

	public void increaseBescherelle() {
		this.lvlBescherelle++;
	}

	public void increaseKey() {
		this.keyLevel++;
	}

	public void setPlace(Place newPlace){
		this.place = newPlace;
	}

	// Display


	// Others

	public void take(String s) {
		if (this.place.getItems().containsKey(s)) {
			Obj item = this.place.getItems().get(s);
			this.objs.put(s, item);
			//Retirer l'item de la hashMap du lieu
		}
		else{
			System.out.print("\nNo kind of" + s + " in this place STOOOPID CAVEMAN !\n");
		}
	}


	public void talk(String s)
	{
		//TODO
		if (this.place.getAnimals().containsKey(s)) {
			Animal animal = this.place.getAnimals().get(s);
			animal.talk(this);
		}
		else{
			System.out.print("\nWhere did you see a " + s + " in this place !? STOOOPID CAVEMAN !\n");
		}
	}

	public void go(String s) {
		if(this.getPlace().getDoors().containsKey(s) && this.getPlace().getDoors() != null) {
			this.getPlace().getDoors().get(s).go(this, s);
		}
		else {
			System.out.println("Sorry, I don't recognize this place\n");
		}
	}

	public void use(String s)
	{
		//TODO
	}

	public void help(String s)
	{
		//TODO
	}
}
