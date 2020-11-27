public class CondemnedDoor extends Door {

	// ***** CONSTRUCTOR *****
	CondemnedDoor(){
		System.out.println("You create a condemned door");
	}

	// ***** METHODS *****

	// Setter

	@Override
	public void open() {
		System.out.println("This door is condemned, you can't open it");
	}

	// Display
}
