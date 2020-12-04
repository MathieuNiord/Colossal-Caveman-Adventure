package objects;

import characters.Hero;
import others.Game;
import others.Script;

public class SexyPoster extends Poster{

	
	// ***** CONSTRUCTOR *****
	
	public SexyPoster(String name, Hero hero) {
		super(name, hero);
	}
	
	// ***** METHODS *****
	
	
	// === COMMANDS ===
	
	@Override
	public void look() {
		Game.printLetterByLetter(Script.SEXY_POSTER);
		this.take(this.HERO);
	}
	
	@Override
	public void take(Hero h) {
		this.HERO.getObjs().put(this.NAME,this);
		this.HERO.getPlace().getItems().remove(this.NAME);
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
