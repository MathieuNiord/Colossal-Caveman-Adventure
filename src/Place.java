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


	// ***** CONSTRUCTOR *****
	public Place(String NAME, boolean inf, boolean elght, Map<String, Animal> animals, Map<String, Door> doors, Map<String, Obj> objs) {
		this.NAME = NAME;
		this.infested = inf;
		this.enlightened = elght;
		this.animals = animals;
		this.doors = doors;
		this.objs = objs;
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
		List arr = new ArrayList<String>(this.doors.keySet());

		return arr;
	}

	public Animal[] getAnimals() {
		//TODO
	}

	public Ennemy getEnnemy() {
		//TODO
	}

	public Map<String, Obj> getItems() {
		//TODO
    }

	public boolean isInfested() {
		//TODO
	}

	public boolean isEnlightened() {
		return this.enlightened;
	}


	public String ToString() {
	}

	// Setter



	// Display


}
