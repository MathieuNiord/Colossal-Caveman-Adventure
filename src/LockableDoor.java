public abstract class LockableDoor extends Door {

	// ***** ATTRIBUTES *****
	private boolean lock;

	// ***** CONSTRUCTOR ****

	LockableDoor(Place p1, Place p2){
		super(p1, p2);
		this.open = false;
		this.lock = true;
	}

	// ***** METHODS *****

	// Getter

	public boolean isUnlock() {
		return !this.lock;
	}

	// Setter

	public void lock() {
		this.lock = true;
	}

	public void unlock() {
		this.lock = false;
	}

	@Override
	public void open() {
		if(!this.lock) {
			super.open();
		}
		else{
			System.out.print("Hmm Hmm...The door is locked buddy...\n");
		}
	}

	// Display

	/*public String toString() {
		if (this.lock == true) {
			return getClass().getSimpleName() + " is locked and consequently closed";
		}
		else {
			return getClass().getSimpleName() + " is unlocked";
		}
	}*/

}
