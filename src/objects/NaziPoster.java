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
		this.HERO.setLife((-10));
		System.out.println(Script.NAZI_POSTER);
	}
	
	@Override
	public void take(Hero h)  {
		
		h.setLife((-10));

		Game.printLetterByLetter(Script.NAZI_POSTER);
		Game.printLetterByLetter("This Poster is now in your inventory, use it to lose life !");
		
		this.HERO.getObjs().put(this.NAME,this);
		this.HERO.getPlace().getItems().remove(this.NAME);
	}
	
	@Override
	public void use(Hero h){
		h.setLife((-10));
	}
	
	@Override
	public void use(Hero h, String s) {
	
	}
	
}
