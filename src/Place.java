import jdk.jfr.Name;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Place {

	// ***** CONSTANTS *****

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
		this.animals = animals;
		this.objs = objs;
		this.enemies = enem;

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

	public List<String> getAllDoorsNames() {

		return new ArrayList<>(this.doors.keySet());
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

	public void setDoors(Map<String, Door> newDoors) {
		this.doors = newDoors;
	}

	public void addDoor(Door d, String destinationName) {

		assert d.getPlaces().containsKey(destinationName);
		// ATTENTION , la valeur de de "destinationName" doit ABSOLUMENT etre une clé
		// contenu dans la map de la porte


		if(this.doors == null) {
			Map<String, Door> mapDoors = new HashMap<>();
			this.doors = mapDoors;
		}

		if(!(this.doors.containsValue(d)) && !(this.doors.containsKey(destinationName)))
			// la lieu ne doit pas déjà contenir la porte ni contenir le meme nom de destination

			this.doors.put(destinationName, d);
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

				retE = new StringBuilder("Il y a " + size + " ennemies :");
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
