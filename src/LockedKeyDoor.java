public class LockedKeyDoor extends LockableDoor{

	// ***** CONSTANTS *****

	// ***** ATTRIBUTES *****

	private int keyLvlNeed;

	// ***** CONSTRUCTORS *****

	LockedKeyDoor(int key, Place p1, Place p2){
		super(p1, p2);
		this.keyLvlNeed = key;
	}

	// ***** METHODS *****

	// Getter

	public int keyLevel(){
		return this.keyLvlNeed;
	}

	// Setter

	@Override
	public void unlock(){
		if(!this.isUnlock()) {
			System.out.print("You do not have the access of this space.\n");
		}
		else if(this.isUnlock()){
			System.out.print("The door is already unlocked stupid...\n");
		}
	}

	public void unlock(int key){
		if(key >= this.keyLvlNeed && !this.isUnlock()) {
			super.unlock();
			System.out.print("Wow !!! Where did you find this key ?\nThe door is now unlocked. Who's the Good Boy ?\n");
		}
		else if(this.isUnlock()){
			System.out.print("The door is already unlocked stupid...\n");
		}
		else{
			System.out.print("You must have the key to open this door STOOOPID CAVEMAN !\n");
		}
	}

	// Display

}
