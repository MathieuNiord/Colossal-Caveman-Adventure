package objects;

import characters.Hero;
import others.Game;
import others.Script;

public class SexyPoster extends Poster{

	
	// ***** CONSTRUCTOR *****
	
	public SexyPoster(String name) {
		super(name);
	}
	
	// ***** METHODS *****
	
	
	// === COMMANDS ===
	
	@Override
	public void look() {
		Game.printLetterByLetter(Script.SEXY_POSTER);
	}
	
	@Override
	public void use(Hero h) {
		h.heal();
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this SexyPoster with something else\n");
	}
	
}
