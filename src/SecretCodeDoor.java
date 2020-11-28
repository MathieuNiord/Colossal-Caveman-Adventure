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
		if (this.CODE.equalsIgnoreCase(code)) {
			super.unlock();
			System.out.print("\nVALID CODE. The door is now unlocked. Good Boy !\n");
		}
		else {
			System.out.println("ERROR CODE. Hey buddy you won't be able to force the code. Even the Nazis are certainly smarter than you...");
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
