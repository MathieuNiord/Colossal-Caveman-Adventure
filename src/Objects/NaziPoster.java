package Objects;

import Characters.Hero;
import Others.Script;

public class NaziPoster extends Poster{
	
	
	// ***** CONSTRUCTOR *****
	
	public NaziPoster(String name, Hero hero) {
		super(name, hero);
	}
	
	// ***** METHODS *****
	
	
	// === COMMANDS ===
	
	@Override
	public void look() throws InterruptedException {
		this.HERO.setLife((-10));
		System.out.println(Script.NAZI_POSTER);
	}
	
	@Override
	public void take(Hero h) throws InterruptedException {
		
		h.setLife((-10));
		
		System.out.println(Script.NAZI_POSTER);
		System.out.println("This Poster is now in your inventory, use it to lose life !");
		
		this.HERO.getObjs().put(this.NAME,this);
		this.HERO.getPlace().getItems().remove(this.NAME);
	}
	
	@Override
	public void use(Hero h) throws InterruptedException {
		h.setLife((-10));
		System.out.println("You loosed life !");
	}
	
}
