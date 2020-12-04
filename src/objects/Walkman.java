package objects;

import characters.Hero;
import others.Game;

public class Walkman extends Obj{
	public Walkman(String name) {
		super(name);
	}
	
	@Override
	public void look() {
		Game.printLetterByLetter("Wow this Walkman has some good music on !!!\n");
	}
	
	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("Allumeeeeerrrrrrrrr le FEUUUUU, ALLUMEEEERRRRRRRRRRR LE FEUUUUUUUUUUU !!!!!!\n");
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this "+ this.NAME+" with something else\n");
	}

	@Override
	public String toString() {
		return this.NAME;
	}
}
