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
	public void look() throws InterruptedException {
		if(this.objs!=null){
			for (Obj obj : this.objs) {
				this.hero.getObjs().put(obj.NAME, obj);
			}
			Game.printLetterByLetter("You just looked in the locker and found : " + this.objs.toString() + " !\n");
			
		}
		
		this.objs = null;
	}

	@Override
	public void take(Hero h) throws InterruptedException {
		Game.printLetterByLetter("What the hell man, you're trying to take A fu**ing Objects.Locker\n");
	}

	@Override
	public void use(Hero h) {
		System.out.println("You cannot use a Objects.Locker STOOPID Caveman");
	}


	// === DISPLAY ===

	@Override
	public String toString(){
		return this.getClass().getSimpleName();
	}

}
