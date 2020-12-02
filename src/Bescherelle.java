public class Bescherelle extends Obj{
	public Bescherelle(String name) {
		super(name);
	}
	
	@Override
	public void use(Hero h) {
	
	}
	
	@Override
	public void take(Hero h) throws InterruptedException {
		h.increaseBescherelle();
		super.take(h);
	}
}
