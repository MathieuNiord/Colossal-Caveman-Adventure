public class Bescherelle extends Obj{
	public Bescherelle(String name) {
		super(name);
	}
	
	@Override
	public void use(Hero h) {
		System.out.println("You cannot use a Bescherelle ...");
	}
	
	@Override
	public void take(Hero h) throws InterruptedException {
		h.increaseBescherelle();
		super.take(h);
	}
	
	@Override
	public void look() throws InterruptedException {
		Game.printLetterByLetter(Script.BESCH_DESCRIPT);
	}
}
