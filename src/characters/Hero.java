package characters;

import others.*;
import objects.*;

import java.util.HashMap;
import java.util.Map;

public class Hero {


	// ***** CONSTANTS *****

	public final static int DEFAULT_HP = 100;
	public final static int DEFAULT_BESCHERELLE_LEVEL = 0;
	public final static int DEFAULT_KEY_LEVEL = 0;
	public final static boolean DEFAULT_IMMUNISED_VALUE = false;
	public final static int DEFAULT_CLUB_DAMAGE = 15;
	public final static int DEFAULT_DAMAGE = 1;

	// ***** ATTRIBUTES *****

	public final String PLAYERNAME;
	private int hp;
	private int keyLevel;
	private int lvlBescherelle;
	private boolean immunised;
	private final Map<String, Obj> objs;
	private Place place;


	// ***** CONSTRUCTOR *****

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


	// === GETTER ===

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

	

	public Place getPlace() {
		return this.place;
	}
	
	public Map<String, Obj> getObjs(){
		return this.objs;
	}

	public boolean isAlive(){
		return this.hp>0;
	}


	// === SETTER ===

	public void increaseBescherelle() {
		this.lvlBescherelle++;
	}

	public void increaseKey() {
		this.keyLevel++;
	}

	public void setLife(int damageHeal){
		this.hp += damageHeal;
		if(damageHeal < 0){
			System.out.println("\nOuch ! You loose " + damageHeal + " points of your life ! Take care my man...\n");
		}
		else{
			System.out.println("\nYou have just gained " + damageHeal + " life points! Well done Champion !\n");
		}
	}

	public void setImmunised(){
		this.immunised=true;
	}

	public void setPlace(Place newPlace){
		this.place = newPlace;
	}


	// === DISPLAY ===

	public void showInventory(){
		System.out.print("\nYour inventory : ");
		System.out.print(this.getObjs().keySet().toString());
	}


	// === COMMANDS ===

	public void attack(Enemy enemy)  {
		if(enemy != null) {
			if (this.objs.containsKey("Club")) {
				enemy.takeDamage(DEFAULT_CLUB_DAMAGE);
				System.out.print("\nHouga Bouga :");
				Game.printLetterByLetter(Script.ANGRY_HERO + "\n\nYEAAAH !!! Come on ! Destroy HIM ! It's a f***ing " + enemy.NAME + " !\n\n");
				Game.printLetterByLetter(enemy.NAME + " took several damages : -" + DEFAULT_CLUB_DAMAGE + " HP\nRest of " + enemy.NAME + " life : " + enemy.getHP());
			} else {
				enemy.takeDamage(DEFAULT_DAMAGE);
				System.out.print("\nHouga Bouga :");
				Game.printLetterByLetter(Script.ANGRY_HERO + "\n\nYEAAAH !!! Come on ! Destroy HIM ! It's a f***ing " + enemy.NAME + " !\n\n");
				Game.printLetterByLetter(enemy.NAME + " took several damages : -" + DEFAULT_DAMAGE + " HP\nRest of " + enemy.NAME + " life : " + enemy.getHP());
			}
			Game.sysClear();
		}
	}

	public void go(String s) {
		if(this.getPlace().getDoors() != null && this.getPlace().getDoors().containsKey(s)) {
			this.getPlace().getDoors().get(s).cross(this, s);
		}
		else {
			System.out.print("\nYou live in a cave ? There's nothing like \"" + s + "\" around you stupid caveman !\n"); //On se fait insulter
		}
	}

	public void heal() {
		if(this.objs.containsKey("SexyPoster")){
			this.objs.remove("SexyPoster");
			Game.printLetterByLetter("\nNo please put this thing away from me ... this is absolutely no time or place for this sort of thing\n");
			this.hp += 20;
			System.out.println("\nYou gained 20 HP\n");
		}
		else{
			Game.printLetterByLetter("\n\nYou got absolutely nothing for healing yourself, you're such a stupid little thing...\n");
			System.out.println("\nYou gained 0 HP, What did you expect ?\n");
		}
	}

	public void lookAt(String s) {
		if(this.getPlace().isContainsEnemies()){
			this.getPlace().getEnemies().look();
		}
		if(this.getPlace().isContainsAnimals() && this.getPlace().getAnimals().containsKey(s)){
			this.getPlace().getAnimals().get(s).look();
		}
		if(this.getPlace().isContainsObjs() && this.getPlace().getItems().containsKey(s)){
			this.getPlace().getItems().get(s).look();
		}
		if (this.getObjs().containsKey(s)) {
			this.getObjs().get(s).look();
		}
	}

	public void take(String s) {
		if (this.place.getItems().containsKey(s)) {
			this.place.getItems().get(s).take(this);
		}
		else{
			System.out.print("\nNo kind of " + s + " in this place STOOOPID CAVEMAN !\n");
		}
	}

	public void talk(String s) {
		if (this.place.getAnimals().containsKey(s)) {
			this.place.getAnimals().get(s).talk(this);
		}
		else{
			System.out.print("\nWhere did you see a " + s + " in this place !? STOOOPID CAVEMAN !\n");
		}
	}

	public void use(String s) {
		if(this.getObjs().containsKey(s)){
			this.getObjs().get(s).use(this);
		}
		else if (s.equalsIgnoreCase("ElectricMeter")) {
			Game.printLetterByLetter("\nI'm not sure you can use this machine, it's heavy and you don't even know how it works.\n");
		}
		else {
			Game.printLetterByLetter("\nYou live in a cave ? There's nothing like \"" + s + "\" around you stupid caveman !\n"); //On se fait insulter
		}

	}

	public void use(String s1,String s2) {
		if(this.getObjs().containsKey(s1)){
			this.getObjs().get(s1).use(this,s2);
		}
	}


	// === OTHER ===

	public void loose() {
		if (this.hp == 0) {
			Game.printLetterByLetter(Script.YOU_LOOSE);
		}
	}

	public void win() {
		if (this.getPlace().getName().equalsIgnoreCase("exit")) {
			Game.printLetterByLetter(Script.YOU_WIN);
		}
	}

	public void quit() {
		this.hp = 0;
	}

}
