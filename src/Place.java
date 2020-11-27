import jdk.jfr.Name;

import java.awt.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

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
	public Place(String NAME, boolean inf, boolean islighted, Map<String, Animal> animals, Map<String, Door> doors, Map<String, Obj> objs) {
		this.NAME = NAME;
		this.infested = inf;
		this.enlightened = islighted;
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
		List<String> arrDoorsNames = new ArrayList<String>(this.doors.keySet());

		return arrDoorsNames;
	}

	public Map<String, Animal> getAnimals() {
		return this.animals;
	}

	public Map<String, Ennemy> getEnnemies() {
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

	public String toStringAnimal() {
		String retA = "";

		if(this.objs != null) {
			if (this.animals.size() != 0) {
				int size = this.animals.size();

				retA = "Il y a " + size + " Animaux dans la pièce :";
				List<String> anim = new ArrayList<String>(this.animals.keySet());

				for (int i = 0; i < size; i++) {
					retA = retA + " " + anim.get(i);
				}
				retA = retA + "\n";
			}
		}

		return retA;
	}

	public String toStringObj() {
		String retO = "";

		if(this.objs != null) {
			if (this.objs.size() != 0) {
				int size = this.objs.size();

				retO = "Il y a " + size + " Objets :";
				List<String> objs = new ArrayList<String>(this.objs.keySet());

				for (int i = 0; i < size; i++) {
					retO = retO + " " + objs.get(i);
				}
				retO = retO + "\n";
			}
		}

		return retO;
	}

	public String toStringDoors() {
		String retD = "";

		if(this.doors != null) {
			if (this.doors.size() != 0) {
				int size = this.doors.size();

				retD = "Il y a " + size + " Objets :";
				List<String> doors = new ArrayList<String>(this.doors.keySet());

				for (int i = 0; i < size; i++) {
					retD = retD + " " + doors.get(i);
				}
				retD = retD + "\n";
			}
		}

		return retD;
	}

	public String toStringEnnemies() {
		String retE = "";

		if(this.ennemies != null) {
			if (this.ennemies.size() != 0) {
				int size = this.ennemies.size();

				retE = "Il y a " + size + " Objets :";
				List<String> ennem = new ArrayList<String>(this.ennemies.keySet());

				for (int i = 0; i < size; i++) {
					retE = retE + " " + ennem.get(i);
				}
				retE = retE + "\n";
			}
		}

		return retE;
	}

	@Override
	public String toString() {
		String strA = this.toStringAnimal();
		String strO = this.toStringObj();
		String strD = this.toStringDoors();
		String strE = this.toStringEnnemies();

		return strA + strO + strD + strE;
	}

}
