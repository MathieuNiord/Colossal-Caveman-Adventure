import jdk.jfr.Name;

import java.awt.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Place {

	// ***** CONSTANTS *****

	// ***** ATTRIBUTES *****

	private final String NAME;
	private boolean infested;
	private boolean enlightened;
	private Map<String, Animal> animals;
	private Map<String, Obj> objs;
	private Map<String, Door> doors;
	private Map<String, Ennemy> ennemies;


	// ***** CONSTRUCTOR *****
	public Place(String NAME, boolean inf, boolean elght, Map<String, Animal> animals, Map<String, Door> doors, Map<String, Obj> objs) {
		this.NAME = NAME;
		this.infested = inf;
		this.enlightened = elght;
		this.animals = animals;
		this.doors = doors;
		this.objs = objs;
	}

	// Gestion des portes

	// ***** METHODS *****

	// Getter

	public String getName() {
		return this.NAME;
	}

	public Map<String, Door> getDoors() {
		return this.doors;
	}

	public List<String> getAllDoorsNames() {
		List<String> arr = new ArrayList<String>(this.doors.keySet());

		return arr;
	}

	public Map<String, Animal> getAnimals() {
		return this.animals;
	}

	public Map<String, Ennemy> getEnnemy() {
		return this.ennemies;
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


	// Setter



	// Display

	public String ToStringAnimal() {
		String ret1 = "";

		if (this.animals.size() != 0) {
			int size = this.animals.size();

			ret1 = "Il y a " + size + " Animaux dans la pièces :";
			List<String> anim = new ArrayList<String>(this.doors.keySet());

			for (int i = 0; i < size; i++) {
				ret1 = ret1 + " " + anim.get(i);
			}
			ret1 = ret1 + "\n";
		}
		return ret1;
	}

	public String ToString() {

	}

}
