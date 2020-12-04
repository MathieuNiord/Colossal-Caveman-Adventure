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
		
		Game.printLetterByLetter(Script.NAZI_POSTER);
		Game.printLetterByLetter("This Poster is now in your inventory, use it to lose life !");
		this.HERO.getObjs().put(this.NAME,this);
		this.HERO.getPlace().getItems().remove(this.NAME);
		
	}
	
	@Override
	public void use(Hero h){
		this.look();
	}
	
	@Override
	public void use(Hero h, String s) {
		Game.printLetterByLetter("You cannot use this NaziPoster with something else");
	}
	
}
