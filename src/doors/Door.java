package doors;

import characters.*;
import others.*;
import interfaces.*;

import java.util.HashMap;

public class Door implements Crossable {


	// ***** ATTRIBUTES *****

	protected boolean open;
	private final HashMap<String, Place> places;


	// ***** CONSTRUCTORS *****

	public Door(Place p1, Place p2){
		this.open = true;
		this.places = new HashMap<>();
		this.places.put(p1.getName(), p1);
		if(p2 != null)
			this.places.put(p2.getName(), p2);
	}


	// ***** METHODS *****


	// === GETTER ===

	public boolean isOpen(){
		return this.open;
	}

	public HashMap<String, Place> getPlaces(){
		return this.places;
	}


	// === SETTER ===

	public void open(){
		this.open = true;
		if(!this.getClass().getSimpleName().equals("Doors.DestructableDoor")){
			System.out.println("\nYou opened the door, u gat dat hommy !");
		}
	}


	// === OTHER ===

	public void cross(Hero hero, String s){
		if(s != null) {
			s = s.toLowerCase();
			if (hero.getPlace().getDoors() != null) {
				if (hero.getPlace().getDoors().containsKey(s)) {
					if (this.isOpen()) {
						hero.setPlace(this.getPlaces().get(s));     //If it's open we can pass
					}
				}
			}
		}
	}

}