import jdk.jfr.Name;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Collections;

public class Place {

	// ***** CONSTANTS *****

	public static final List<String> AnimalFlag = Arrays.asList("Monkey", "Animal");
	public static final List<String> EnnemiesFlag = Arrays.asList("AccountGuy", "FinalBoss", "Zombie");
	public static final List<String> ObjsFlag = Arrays.asList("Item", "Weapon", "Heal", "Casier");

	// ***** ATTRIBUTES *****

	private final String NAME;
	private final boolean infested;
	private boolean enlightened;

	private Map<String, Animal> animals;
	private Map<String, Obj> objs;
	private Map<String, Door> doors;
	private Map<String, Ennemy> enemies;


	// ***** CONSTRUCTOR *****
	public Place(String NAME, boolean inf, boolean isEnlighted, Map<String, Animal> animals, Map<String, Obj> objs, Map<String, Ennemy> enem) {
		this.NAME = NAME;
		this.infested = inf;
		this.enlightened = isEnlighted;

		// On ajoute avec AddAndCreate les animaux, objets et ennemies
		this.animals = null;
		this.objs = null;
		this.enemies = null;

		// Il faut impérativement ajouter les portes après avec la méthode addDoors
		this.doors = null;
	}

	// ***** METHODS *****

	// Getter

	public String getName() {
		return this.NAME;
	}

	public Map<String, Door> getDoors() {
		return this.doors;
	}

	public String getDestinationName(Door d) {
		ArrayList<String> list = new ArrayList<>(d.getPlaces().keySet());

		String res = list.get(0);
		if(list.contains(this.NAME)) {
			if (res.equals(this.NAME)) {
				res = list.get(1);
			}
		}
		return res;
	}

	public Map<String, Animal> getAnimals() {
		return this.animals;
	}

	public Map<String, Ennemy> getEnemies() {
		return this.enemies;
	}

	public Map<String, Obj> getItems() {
		return this.objs;
    }

	public boolean isInfested() {
		return this.infested;
	}

	public boolean isEnlightened() {
		return this.enlightened;
	}

	public boolean isContainsAnimals() {
		boolean temp = true;
		if(this.animals == null || this.animals.size() == 0){
			temp = false;
		}

		return temp;
	}

	public boolean isContainsObjs() {
		boolean temp = true;
		if(this.objs == null || this.objs.size() == 0){
			temp = false;
		}

		return temp;
	}

	public boolean isContainsDoors() {
		boolean temp = true;
		if(this.doors == null || this.doors.size() == 0){
			temp = false;
		}

		return temp;
	}

	public boolean isContainsEnemies() {
		boolean temp = true;
		if(this.enemies == null || this.enemies.size() == 0){
			temp = false;
		}

		return temp;
	}

	// Setter

	public void AddAndCreateAnimal(String sousType, String name, int Blvl) {
		if(this.animals == null) {
			this.animals = new HashMap<String, Animal>();
		}

		// On vérifie le flag pour construire avec le bon type
		if(Place.AnimalFlag.contains(sousType)) {
			if (sousType.equals("Animal")) {
				Animal ani = new Animal(name, Blvl);
				this.animals.put(name, ani);
			}
			if (sousType.equals("Monkey")) {
				Animal ani = new Monkey(name, Blvl);
				this.animals.put(name, ani);
			}
		}
	}

	public void AddAndCreateEnemy(String sousType, int hp, int atk, Obj loot) {
		if(this.enemies == null) {
			this.enemies = new HashMap<String, Ennemy>();
		}

		// On vérifie le flag pour construire avec le bon type
		if(Place.EnnemiesFlag.contains(sousType)) {
			if (sousType.equals("AccountGuy")) {
				Ennemy enem = new AccountGuy(hp, atk, loot);
				this.enemies.put("AccountGuy", enem);
			}
			/*if (sousType.equals("FinalBoss")) {
				Ennemy enem = new FinalBoss();
				this.enemies.put("FinalBoss", enem);
			}
			if (sousType.equals("Zombie")) {
				Ennemy enem = new Zombie();
				this.enemies.put("Zombie", enem);
			}*/
		}
	}

	public void AddAndCreateObject(String sousType, String name, int value) {
		if(this.objs == null) {
			this.objs = new HashMap<String, Obj>();
		}

		// On vérifie le flag pour construire avec le bon type
		if(Place.ObjsFlag.contains(sousType)) {
			if (sousType.equals("Item")) {
				Obj o = new Item(name);
				this.objs.put(name, o);
			}
			if (sousType.equals("Weapon")) {
				Obj o = new Weapon(name, value);
				this.objs.put(name, o);
			}
			if (sousType.equals("Heal")) {
				Obj o = new Heal(name, value);
				this.objs.put(name, o);
			}
			/*if (sousType.equals("Casier")) {
				Obj o = new Casier(name);
				this.objs.put(name, o);
			}*/
		}
	}

	public void addDoor(Door d) {
		if (this.doors == null) {
			this.doors = new HashMap<String, Door>();
		}
		if(!this.doors.containsValue(d)) {
			// On récupère le nom de la destination  en fonction du sens où on emprunte la porte
			String destName = this.getDestinationName(d);
			this.doors.put(destName, d);
		}
	}

	// Display

	public String toStringAnimal() {
		StringBuilder retA = new StringBuilder();

		if(this.animals != null) {
			if (this.animals.size() != 0) {
				int size = this.animals.size();

				retA = new StringBuilder("Il y a " + size + " animaux dans la pièce :");
				List<String> anim = new ArrayList<>(this.animals.keySet());

				for (int i = 0; i < size; i++) {
					retA.append(" ").append(anim.get(i));
				}
				retA.append("\n");
			}
		}

		return retA.toString();
	}

	public String toStringObj() {
		StringBuilder retO = new StringBuilder();

		if(this.objs != null) {
			if (this.objs.size() != 0) {
				int size = this.objs.size();

				retO = new StringBuilder("Il y a " + size + " objets :");
				List<String> objs = new ArrayList<>(this.objs.keySet());

				for (int i = 0; i < size; i++) {
					retO.append(" ").append(objs.get(i));
				}
				retO.append("\n");
			}
		}

		return retO.toString();
	}

	// A refaire : il ne faut pas afficher la pièce dans laquelle le héros se trouve
	public String toStringDoors() {
		StringBuilder retD = new StringBuilder();

		if(this.doors != null) {
			if (this.doors.size() != 0) {
				int size = this.doors.size();

				retD = new StringBuilder("Il y a " + size + " sorties :");
				List<String> doors = new ArrayList<>(this.doors.keySet());

				for (int i = 0; i < size; i++) {
					retD.append(" ").append(doors.get(i));
				}
				retD.append("\n");
			}
		}

		return retD.toString();
	}

	public String toStringEnemies() {
		StringBuilder retE = new StringBuilder();

		if(this.enemies != null) {
			if (this.enemies.size() != 0) {
				int size = this.enemies.size();

				retE = new StringBuilder("Il y a " + size + " ennemie :");
				List<String> enemy = new ArrayList<>(this.enemies.keySet());

				for (int i = 0; i < size; i++) {
					retE.append(" ").append(enemy.get(i));
				}
				retE.append("\n");
			}
		}

		return retE.toString();
	}

	@Override
	public String toString() {
		String intro = "Vous êtes dans : " + this.getName() + "\n";

		String isEnl = "";
		String isInf = "";
		String strA = "";
		String strO = "";
		String strD = "";
		String strE = "";

		if (this.isContainsDoors()) {
			strD = this.toStringDoors();
		}


		if(!this.isEnlightened()) {
			isEnl = "La pièce n'est pas éclairée, vous ne voyez rien\n";
		}
		else {
			if (this.isInfested()) {
				isInf = "La pièce est infecté\n";
			}

			if (this.isContainsAnimals()) {
				strA = this.toStringAnimal();
			}

			if (this.isContainsObjs()) {
				strO = this.toStringObj();
			}

			if (this.isContainsEnemies()) {
				strE = this.toStringEnemies();
			}
		}

		return intro + isInf + isEnl + strA + strO + strD + strE;
	}

}
