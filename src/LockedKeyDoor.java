import javax.sound.midi.SysexMessage;

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

	public boolean isOpen(int key){
		boolean res = false;
		if(key == this.keyLvlNeed){
			res = true;
		}
		return res;
	}

	// Getter

	public int keyLevel(){
		return this.keyLvlNeed;
	}

	// Setter

	public void unlock(int key){
		if(key == this.keyLvlNeed){
			super.unlock();
		}
		else{
			System.out.print("\nYou must have key to open this door STOOOPID CAVEMAN !\n");
		}
	}

	// Display

}
