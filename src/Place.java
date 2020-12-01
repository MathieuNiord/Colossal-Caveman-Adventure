import java.util.*;
import java.util.List;

public class Place {

	// ***** CONSTANTS *****

	public static final List<String> ANIMALFLAG = Arrays.asList("Monkey", "Animal");
	public static final List<String> ENNEMIESFLAG = Arrays.asList("AccountGuy", "FinalBoss", "Zombie");
	public static final List<String> OBJSFLAG = Arrays.asList("Item", "Weapon", "Heal", "Casier");

	// ***** ATTRIBUTES *****

	private final String NAME;
	private final boolean infested;
	private boolean enlightened;

	private Map<String, Animal> animals;
	private Map<String, Obj> objs;
	private Map<String, Door> doors;
	private Map<String, Door> left;
	private Map<String, Door> right;
	private Map<String, Door> up;
	private Map<String, Door> down;
	private Map<String, Ennemy> enemies;


	// ***** CONSTRUCTOR *****
	public Place(String NAME, boolean inf, boolean isEnlighted) {
		this.NAME = NAME;
		this.infested = inf;
		this.enlightened = isEnlighted;

		// On ajoute avec AddAndCreate les animaux, objets et ennemies
		this.animals = null;
		this.objs = null;
		this.enemies = null;

		// Il faut impérativement ajouter les portes après avec la méthode addDoors
		this.doors = null;
		this.left = null;
		this.right = null;
		this.up = null;
		this.down = null;
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
		return (this.animals != null && this.animals.size() > 0);
	}

	public boolean isContainsObjs() {
		return (this.objs != null && this.objs.size() > 0);
	}

	public boolean isContainsDoors() {
		return (this.doors != null && this.doors.size() > 0);
	}

	public boolean isContainsEnemies() {
		return (this.enemies != null && this.enemies.size() > 0);
	}

	// Setter

	public void switchEnlightened() {
		this.enlightened = !this.enlightened;
	}

	public void addAndCreateAnimal(String sousType, String name, int Blvl) {
		if(this.animals == null) {
			this.animals = new HashMap<>();
		}

		// On vérifie le flag pour construire avec le bon type
		if(Place.ANIMALFLAG.contains(sousType)) {
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

	public void addAndCreateEnemy(String name, int hp, int dmg, Obj loot, String op, String atk, String dft) {
		if(this.enemies == null) {
			this.enemies = new HashMap<>();
		}
		Ennemy enem = new Ennemy(name, hp, dmg, loot, op, atk, dft);
		this.enemies.put(name, enem);
	}

	public void addAndCreateObject(String sousType, String name, int value) {
		if(this.objs == null) {
			this.objs = new HashMap<>();
		}

		// On vérifie le flag pour construire avec le bon type
		if(Place.OBJSFLAG.contains(sousType)) {
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

	public void addDoor(Door d, String where) {
		if (this.doors == null) {
			this.doors = new HashMap<>();
		}
		if(!this.doors.containsValue(d)) {
			// On récupère le nom de la destination en fonction du sens où on emprunte la porte
			String destName = this.getDestinationName(d);
			this.doors.put(destName, d);

			if(where.equals("up")) {
				if(this.up == null) {
					this.up = new HashMap<>();
				}
				this.up.put(destName, d);
			}
			if(where.equals("down")) {
				if(this.down == null) {
					this.down = new HashMap<>();
				}
				this.down.put(destName, d);
			}
			if(where.equals("left")) {
				if(this.left == null) {
					this.left = new HashMap<>();
				}
				this.left.put(destName, d);
			}
			if(where.equals("right")) {
				if(this.right == null) {
					this.right = new HashMap<>();
				}
				this.right.put(destName, d);
			}
		}
	}

	// Display

	public String toStringAnimal() {
		StringBuilder retA = new StringBuilder();

		if(this.animals != null) {
			if (this.animals.size() != 0) {
				int size = this.animals.size();

				retA = new StringBuilder("There is " + size + " animal(s) in this room :");
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

				retO = new StringBuilder("There is " + size + " object(s) :");
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

		if(this.up != null) {
			if (this.up.size() != 0) {

				int size = this.up.size();
				retD.append("There is ").append(size).append(" exits in up : ");
				List<String> up = new ArrayList<>(this.up.keySet());

				retD.append(up.get(0));
				for (int i = 1; i < size; i++) {
					retD.append(" | ").append(up.get(i));
				}
				retD.append("\n");
			}
		}
		if(this.down != null) {
			if (this.down.size() != 0) {

				int size = this.down.size();
				retD.append("There is ").append(size).append(" exits in down : ");
				List<String> down = new ArrayList<>(this.down.keySet());

				retD.append(down.get(0));
				for (int i = 1; i < size; i++) {
					retD.append(" | ").append(down.get(i));
				}
				retD.append("\n");
			}
		}
		if(this.left != null) {
			if (this.left.size() != 0) {

				int size = this.left.size();
				retD.append("There is ").append(size).append(" exits in left : ");
				List<String> left = new ArrayList<>(this.left.keySet());

				retD.append(left.get(0));
				for (int i = 1; i < size; i++) {
					retD.append(" | ").append(left.get(i));
				}
				retD.append("\n");
			}
		}
		if(this.right != null) {
			if (this.right.size() != 0) {

				int size = this.right.size();
				retD.append("There is ").append(size).append(" exits in right : ");
				List<String> right = new ArrayList<>(this.right.keySet());

				retD.append(right.get(0));
				for (int i = 1; i < size; i++) {
					retD.append(" | ").append(right.get(i));
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

				retE = new StringBuilder("There is " + size + " ennemie :");
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
		String intro = "You are in : " + this.getName() + "\n";

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
			isEnl = "The room is not lit, you can't see anything\n";
		}
		else {
			if (this.isInfested()) {
				isInf = "The room is infected\n";
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
