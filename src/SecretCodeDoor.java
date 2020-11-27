public class SecretCodeDoor extends LockableDoor {

	// ***** ATTRIBUTES *****

	private final String CODE;

	// ***** CONSTRUCTOR *****
	SecretCodeDoor(String code){
		this.CODE = code;
	}

	// ***** METHODS *****

	// Setter

	public void unlock(String code) {
		if (this.CODE.equals(code)) {
			super.unlock();
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
