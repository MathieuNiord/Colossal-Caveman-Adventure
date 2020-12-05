package objects;

import characters.*;
import others.*;

import java.util.ArrayList;

public class Locker extends Obj{


	// ***** ATTRIBUTES *****

	private ArrayList<Obj> objs;
	private final Hero hero;
	
	public Locker(String name, Hero hero) {
		super(name);
		this.objs = null;
		this.hero = hero;
	}


	// ***** METHODS *****


	// === GETTER ===

	public ArrayList<Obj> getObjs(){
		return this.objs;
	}
	
	
	// === SETTER ===

	public void addObj(Obj o){
		if(this.objs==null){
			this.objs = new ArrayList<>();
		}
		this.objs.add(o);
	}


	// === COMMANDS ===

	@Override
	public void look() {
		if(this.objs!=null){
			for (Obj obj : this.objs) {
				this.hero.getObjs().put(obj.NAME, obj);
			}
			Game.printLetterByLetter("You just looked in the locker and found : " + this.objs.toString() + " !\n", Script.DEFAULT_NARRATOR);
		}
		else {
			Game.printLetterByLetter("Locker is empty.\n", Script.DEFAULT_NARRATOR);
		}
		
		this.objs = null;
	}

	@Override
	public void take(Hero h) {
		Game.printLetterByLetter("What the hell man, you're trying to take a god damn Locker\n", Script.DEFAULT_NARRATOR);
	}

	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("You cannot use a Locker STOOPID Caveman\n", Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h, String s) {
		this.use(h);
	}
	
}
