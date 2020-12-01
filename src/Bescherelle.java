public class Bescherelle extends Obj{
	public Bescherelle(String name) {
		super(name);
	}
	
	@Override
	public void use(Hero h) {
	
	}
	
	@Override
	public void take(Hero h) {
		h.increaseBescherelle();
		h.getObjs().put(this.name,this);
		h.getPlace().getItems().remove(this.name);
	}
}
