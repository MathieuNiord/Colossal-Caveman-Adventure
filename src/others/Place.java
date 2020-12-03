package others;

import characters.*;
import doors.*;
import objects.*;
import interfaces.*;
import java.util.*;

public class Place implements Lookable {


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
	private Enemy enemy;


	// ***** CONSTRUCTOR *****

	public Place(String NAME, boolean inf, boolean isEnlighted) {
		this.NAME = NAME;
		this.infested = inf;
		this.enlightened = isEnlighted;

		// On ajoute avec AddAndCreate les animaux, objets et ennemies
		this.animals = null;
		this.objs = null;
		this.enemy = null;

		// Il faut impérativement ajouter les portes après avec la méthode addDoors
		this.doors = null;
		this.left = null;
		this.right = null;
		this.up = null;
		this.down = null;
	}


	// ***** METHODS *****


	// === GETTER ===

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

	public Enemy getEnemies() {
		return this.enemy;
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
		return (this.enemy != null);
	}


	// === SETTER ===

	public void setEnlightened() {
		this.enlightened =true;
	}

	public void addAnimal(Animal ani) {
		if(this.animals == null) {
			this.animals = new HashMap<>();
		}
		this.animals.put(ani.NAME,ani);
	}

	public void addAndCreateEnemy(String name, int hp, int dmg, Obj loot, String op, String atk, String dft, String desc) {
		if(this.enemy == null) {
			this.enemy = new Enemy(name, hp, dmg, loot, op, atk, dft,desc);
		}
	}

	public void setEnemy(Enemy enemy){
		this.enemy = enemy;
	}

	public void addObject(Obj o) {
		if(this.objs == null) {
			this.objs = new HashMap<>();
		}
		this.objs.put(o.toString(),o);
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


	// === COMMANDS ===

	@Override
	public void look() {
		Game.printLetterByLetter(this.toString());
	}


	// === DISPLAY ===

	public String toStringAnimal() {
		StringBuilder retA = new StringBuilder();

		if(this.animals != null) {
			if (this.animals.size() != 0) {
				int size = this.animals.size();

				retA = new StringBuilder("There is " + size + " animal(s) in this room : ");
				List<String> anim = new ArrayList<>(this.animals.keySet());

				retA.append(anim.get(0));
				for (int i = 1; i < size; i++) {
					retA.append(" | ").append(anim.get(i));
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

				retO = new StringBuilder("There is " + size + " object(s) : ");
				List<String> objs = new ArrayList<>(this.objs.keySet());

				retO.append(objs.get(0));
				for (int i = 1; i < size; i++) {
					retO.append(" | ").append(objs.get(i));
				}
				retO.append("\n");
			}
		}

		return retO.toString();
	}

	public String toStringDoors() {
		StringBuilder retD = new StringBuilder();

		if(this.up != null) {
			if (this.up.size() != 0) {

				int size = this.up.size();
				retD.append("There is ").append(size).append(" exit(s) in up : ");
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
				retD.append("There is ").append(size).append(" exit(s) in down : ");
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
				retD.append("There is ").append(size).append(" exit(s) in left : ");
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
				retD.append("There is ").append(size).append(" exit(s) in right : ");
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

		if(this.enemy != null) {
			retE.append("There's ennemy : ").append(this.enemy.NAME);
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
