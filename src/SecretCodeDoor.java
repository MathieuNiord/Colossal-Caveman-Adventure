public class SecretCodeDoor extends LockableDoor {

	// ***** ATTRIBUTES *****

	private final String CODE;

	// ***** CONSTRUCTOR *****
	SecretCodeDoor(String code, Place p1, Place p2){
		super(p1, p2);
		this.CODE = code;
	}

	// ***** METHODS *****

	// Setter

	public void unlock(String code) {
		if (this.CODE.equals(code)) {
			super.unlock();
			System.out.print("\nVALID CODE : The door is now unlocked. Good Boy !\n");
		}
		else {
			System.out.println("Error code, you can't open this door");
		}
	}

	@Override
	public void unlock() {
		System.out.println("You must enter a code to unlock this door");
	}

	// Display

	@Override
	public String toString() {
		return super.toString() + ", code access : " + this.CODE;
	}

}
