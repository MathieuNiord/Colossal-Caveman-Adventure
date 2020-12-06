package objects;

import characters.Hero;
import others.Game;
import others.Script;

public class NaziPoster extends Poster{
	
	
	// ***** CONSTRUCTOR *****
	
	public NaziPoster(String name) {
		super(name);
	}
	
	// ***** METHODS *****
	
	
	// === COMMANDS ===
	
	@Override
	public void look() {
		System.out.println(Script.NAZI_POSTER);
	}
	
	@Override
	public void take(Hero h)  {
		super.take(h);
		Game.printLetterByLetter("\nThis Poster is now in your inventory, use it to lose life !\n", Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h){
		this.look();
		h.setLife(10);
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this NaziPoster with something else\n", Script.DEFAULT_NARRATOR);
	}
	
}
