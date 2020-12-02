public class CondemnedDoor extends Door {

	// ***** CONSTRUCTOR *****
	CondemnedDoor(Place p1, Place p2){
		super(p1, p2);
		this.open = false;
	}

	// ***** METHODS *****

	// Setter

	@Override
	public void open() {
		System.out.println("This door is condemned, you can't open it");
	}

	@Override
	public void go(Hero hero, String s){
		this.open();
	}

	// Display
}
