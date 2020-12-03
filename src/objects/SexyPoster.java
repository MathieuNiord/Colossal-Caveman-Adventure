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
		Game.printLetterByLetter("Hmmmm ! What a seeeexy girl !\n\nYou took the poster and put it in your inventory\n");
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
	
	}
	
}
