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

	//Other

	@Override
	public void go(Hero hero, String s){
		if(this.getPlaces().containsKey(s)){
			if(this.isUnlock()){
				hero.setPlace(this.getPlaces().get(s));     //Si c'est déverrouillé on peut passer
				System.out.print("\nYou entered in " + s + "\n");
			}
		}
		else{
			System.out.print("\nYou live in a cave ? There's nothing like " + s + "around you stupid caveman !\n"); //On se fait insulter
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
