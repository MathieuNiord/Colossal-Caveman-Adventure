package objects;

import characters.Hero;
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
		this.HERO.heal();
		System.out.println(Script.SEXY_POSTER);
	}
	
	@Override
	public void take(Hero h) {
		
		h.heal();
		
		System.out.println(Script.SEXY_POSTER);
		System.out.println("This Poster is now in your inventory, use it to heal yourself !");
		
		this.HERO.getObjs().put(this.NAME,this);
		this.HERO.getPlace().getItems().remove(this.NAME);
	}
	
	@Override
	public void use(Hero h) {
		h.heal();
		System.out.println("You healed !");
	}

}
