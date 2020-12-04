package objects;

import characters.Hero;
import others.Game;
import others.Script;

public class NaziPoster extends Poster{
	
	
	// ***** CONSTRUCTOR *****
	
	public NaziPoster(String name, Hero hero) {
		super(name, hero);
	}
	
	// ***** METHODS *****
	
	
	// === COMMANDS ===
	
	@Override
	public void look() {
		System.out.println(Script.NAZI_POSTER);
		this.HERO.setLife((-10));
	}
	
	@Override
	public void take(Hero h)  {
		super.take(h);
		Game.printLetterByLetter("\nThis Poster is now in your inventory, use it to lose life !\n");
	}
	
	@Override
	public void use(Hero h){
		this.look();
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this NaziPoster with something else\n");
	}
	
}
