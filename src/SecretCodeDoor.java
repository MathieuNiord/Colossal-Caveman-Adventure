import java.util.Random;
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

		Random rand = new Random();
		int tmp = rand.nextInt(10 + 1);

		if (this.CODE.equalsIgnoreCase(code)) {
			super.unlock();
			if(tmp % 2 == 0){
				System.out.print("\nVALID CODE. The door is now unlocked. Good Boy !\n");
			}
			else{
				System.out.print("\nVALID CODE. Good Gosh ! You're smarter than I thought ! You unlocked the door !\n");
			}
		}
		else {
			if(tmp % 2 == 0){
				System.out.println("ERROR CODE. Hey buddy you won't be able to force the code. Even the Nazis are certainly smarter than you...");
			}
			else{
				System.out.print("\nERROR CODE. Hmmm, maybe you're not a good writer...\n");
			}
		}
	}

	//Other

	@Override
	public void go(Hero hero, String s){

		Scanner sc = new Scanner(System.in);	//Nouveau scanner
		System.out.print("\nCODE : ");
		String code = sc.nextLine();			//L'utilisateur rentre le code

		this.unlock(code);
		if(this.isUnlock()){
			hero.setPlace(this.getPlaces().get(s));
		}
	}

	// Display

	/*@Override
	public String toString() {
		return super.toString() + ", code access : " + this.CODE;
	}*/

}
