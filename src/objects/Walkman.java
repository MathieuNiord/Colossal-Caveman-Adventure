package objects;

import characters.Hero;
import others.Game;

public class Walkman extends Obj{
	public Walkman(String name) {
		super(name);
	}
	
	@Override
	public void look() {
		System.out.println("Wow this Walkman has a good music on it !!!");
	}
	
	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("Allumeeeeerrrrrrrrr le FEUUUUU, ALLUMEEEERRRRRRRRRRR LE FEUUUUUUUUUUU !!!!!!\n\n");
	}
	
	@Override
	public void use(Hero h, String s) {
	
	}
}
