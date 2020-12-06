package characters;

import others.*;
import objects.*;
import  doors.*;

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
	private boolean quit = false;


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

	public boolean isQuit() {
		return this.quit;
	}


	// === SETTER ===

	public void increaseBescherelle() {
		this.lvlBescherelle++;
	}

	public void increaseKey() {
		this.keyLevel++;
	}

	public void setLife(int damage){
		this.hp += damage;
		if(damage < 0){
			Game.printLetterByLetter("Ouch ! You loose " + -damage + " points of your life ! Take care my man...\n\n\n", Script.DEFAULT_NARRATOR);
		}
	}

	public void setImmunised(){
		this.immunised=true;
	}

	public void setPlace(Place newPlace){
		this.place = newPlace;
	}


	// === COMMANDS ===

	public void attack(Enemy enemy)  {
		if(enemy != null) {
			if (this.objs.containsKey(Script.DEFAULT_CLUB_NAME)) {
				enemy.takeDamage(DEFAULT_CLUB_DAMAGE);
				Game.printLetterByLetter(Script.ANGRY_HERO, "HOUGA BOUGA");
				Game.printLetterByLetter("YEAAAH !!! Come on ! Destroy HIM ! It's a f***ing " + enemy.NAME + " !\n\n", Script.DEFAULT_NARRATOR);
				System.out.print("\n" + enemy.NAME + " took several damages : -" + DEFAULT_CLUB_DAMAGE + " HP\n\nREST OF " + enemy.NAME.toUpperCase() + " LIFE : " + enemy.getHP() + "\n\n");
			} else {
				enemy.takeDamage(DEFAULT_DAMAGE);
				Game.printLetterByLetter(Script.ANGRY_HERO, "HOUGA BOUGA");
				Game.printLetterByLetter("YEAAAH !!! Come on ! Destroy HIM ! It's a f***ing " + enemy.NAME + " !\n\n", Script.DEFAULT_NARRATOR);
				System.out.print("\n" + enemy.NAME + " took several damages : -" + DEFAULT_DAMAGE + " HP\nREST OF " + enemy.NAME.toUpperCase() + " LIFE : " + enemy.getHP() + "\n\n");
			}
			Game.pressAnyKeyToContinue();
			Game.sysClear();
		}
	}
	
	private void go_aux(Map<String,Door> m){
		if(m!=null){
			switch (m.size()) {
				//If there's no door on the side that the user gave
				case 0 -> Game.printLetterByLetter("There's no door on this side and, despite the fact you're a freak, there's absolutely no way you can pass a wall...\n", Script.DEFAULT_NARRATOR);
				//If there's only one door
				case 1 -> {
					String res = m.entrySet().iterator().next().getKey();            //Not a beauty, I know but I need the key
					m.get(res).cross(this, res);
					System.out.print("You enter in " + this.getPlace().getName().toUpperCase() + "\n");
				}
				//If there's too much choices
				default -> System.out.println("\nWhich room ? Please make sure to write \"go + the room where you want to go\"\n");
			}
		}
		else{
			Game.printLetterByLetter("\nThere's no door on this side and, despite the fact you're a freak, there's absolutely no way you can pass a wall...\n", Script.DEFAULT_NARRATOR);
		}
	}
	
	public void go(String s) {
		s = s.toLowerCase();																							//It's for the user, he can tap room, ROOM, RoOm, no matter
		//Only if there is doors around
		if (this.getPlace().getDoors() != null) {
		
			switch (s.toLowerCase()) {
				case "up" -> go_aux(this.getPlace().getUpDoors());
				case "down" -> go_aux(this.getPlace().getDownDoors());
				case "left" -> go_aux(this.getPlace().getLeftDoors());
				case "right" -> go_aux(this.getPlace().getRightDoors());
				default -> {
					if (this.getPlace().getDoors().containsKey(s)) {
						this.getPlace().getDoors().get(s).cross(this, s);
						System.out.print("You enter in " + this.getPlace().getName().toUpperCase() + "\n");
					}
					else {
						//If the user gave a name which doe's not exit around the room where he is
						Game.printLetterByLetter("You live in a cave ? There's nothing like \"" + s + "\" around you stupid caveman !", Script.DEFAULT_NARRATOR);
					}
				}
			}
		}
		else {
			Game.printLetterByLetter("You're locked in this room...No escape\n", Script.DEFAULT_NARRATOR);
			this.quit(this.PLAYERNAME);
		}
	}

	public void heal() {
		if(this.objs.containsKey(Script.DEFAULT_SEXYPOSTER_NAME)){
			this.objs.remove(Script.DEFAULT_SEXYPOSTER_NAME);
			Game.printLetterByLetter("No please put this thing away from me ... this is absolutely no time or place for this sort of thing\n", Script.DEFAULT_NARRATOR);
			this.hp += 20;
			System.out.println("\nYou gained 20 HP\n");
		}
		else{
			Game.printLetterByLetter("You got absolutely nothing for healing yourself, you're such a stupid little thing...\n", Script.DEFAULT_NARRATOR);
			System.out.println("\nYou gained 0 HP, What did you expect ?\n");
		}
	}

	public void lookAt(String s) {
		if(s != null) {
			s = s.toLowerCase();
			if (this.getPlace().isContainsEnemies()) {
				this.getPlace().getEnemies().look();
			} else {
				if (this.getPlace().isContainsAnimals() && this.getPlace().getAnimals().containsKey(s)) {
					this.getPlace().getAnimals().get(s).look();
				} else {
					if (this.getPlace().isContainsObjs() && this.getPlace().getItems().containsKey(s)) {
						this.getPlace().getItems().get(s).look();
					} else {
						if (this.getObjs().containsKey(s)) {
							this.getObjs().get(s).look();
						} else {
							Game.printLetterByLetter("You're trying to look at something that not exist or not lookable.\n", Script.DEFAULT_NARRATOR);
						}
					}
				}
			}
		}
	}

	public void take(String s) {
		if(s != null) {
			s = s.toLowerCase();
			if (this.place.getItems().containsKey(s)) {
				this.place.getItems().get(s).take(this);
			} else if (this.getPlace().isContainsAnimals() && this.getPlace().getAnimals().containsKey(s)) {
				Game.printLetterByLetter("No please ! Put this " + s + " down on the floor. You're such a savage !\n", Script.DEFAULT_NARRATOR);
			} else {
				Game.printLetterByLetter("No kind of " + s + " in this place STOOOPID CAVEMAN !\n", Script.DEFAULT_NARRATOR);
			}
		}
	}

	public void talk(String s) {
		if(s != null) {
			s = s.toLowerCase();
			if (this.place.isContainsAnimals() && this.place.getAnimals().containsKey(s)) {
				this.place.getAnimals().get(s).talk(this);
			} else {
				Game.printLetterByLetter("Where did you see a " + s + " in this place !? STOOOPID CAVEMAN !\n", Script.DEFAULT_NARRATOR);
			}
		}
	}

	public void use(String s) {
		if(s != null) {
			s = s.toLowerCase();
			if (this.getObjs().containsKey(s.toLowerCase())) {
				this.getObjs().get(s).use(this);
			} else if (this.getPlace().isContainsObjs() &&  s.equalsIgnoreCase(Script.DEFAULT_ELECTRICMETER_NAME)) {
				Game.printLetterByLetter("I'm not sure you can use this machine, it's heavy and you don't even know how it works.\n", Script.DEFAULT_NARRATOR);
			} else if (this.getPlace().isContainsAnimals() && this.getPlace().getAnimals().containsKey(s)) {
				Game.printLetterByLetter("Wh..Wha...WHAT !? No you can't use this " + s + " !\n", Script.DEFAULT_NARRATOR);
			} else if (this.getPlace().getItems().containsKey(s)) {
				Game.printLetterByLetter("Maybe you can take it before try to use it, simple suggestion.\n", Script.DEFAULT_NARRATOR); //On se fait insulter
			} else {
				Game.printLetterByLetter("You live in a cave ? There's nothing like \"" + s + "\" around you stupid caveman !\n", Script.DEFAULT_NARRATOR); //On se fait insulter
			}
		}
	}

	public void use(String s1,String s2) {
		if(s1 != null && s2 != null) {
			s1 = s1.toLowerCase();
			s2 = s2.toLowerCase();
			if (this.getObjs().containsKey(s1)) {
				this.getObjs().get(s1).use(this, s2);
			}
		}
	}


	// === DISPLAY ===

	public void showInventory(){
		System.out.print("\nYour inventory : ");
		System.out.print(this.getObjs().keySet().toString());
	}


	// === OTHER ===

	public void quit(String name) {
		//EXIT
		System.out.print(Script.GAME_OVER + name + " !\n");
		this.quit = true;
		try {
			Thread.sleep(5000);
			System.exit(0);
		}
		catch (final Exception e) {
			System.out.println("Error");
		}
	}

}
