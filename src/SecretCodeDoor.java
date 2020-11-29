import java.util.Scanner;

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

	//Other

	@Override
	public void go(Hero hero, String s){
		if(this.getPlaces().containsKey(s)){
			Scanner sc = new Scanner(System.in);
			System.out.print("\nCODE : ");
			String code = sc.nextLine();
			this.unlock(code);
			if(this.isUnlock()){
				hero.setPlace(this.getPlaces().get(s));
				System.out.print("\nYou entered in " + s + "\n");
			}
		}
		else{
			System.out.print("\nYou live in a cave ? There's nothing like " + s + "around you stupid caveman !\n"); //On se fait insulter
		}
	}

	// Display

	/*@Override
	public String toString() {
		return super.toString() + ", code access : " + this.CODE;
	}*/

}
