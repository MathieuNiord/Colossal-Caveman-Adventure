package doors;

import characters.*;
import others.*;

import java.util.Random;

public class LockedKeyDoor extends LockableDoor{


	// ***** ATTRIBUTES *****

	public final int KEY_LVL_NEED;


	// ***** CONSTRUCTOR *****

	public LockedKeyDoor(int key, Place p1, Place p2){
		super(p1, p2);
		this.KEY_LVL_NEED = key;
	}


	// ***** METHODS *****
	
	
	// === SETTER ===

	@Override
	public void unlock(){
		if(!this.isUnlock()) {
			System.out.print("You do not have the access of this space.\n");
		}
	}

	public void unlock(int key){
		if(key >= this.KEY_LVL_NEED && !this.isUnlock()) {
			super.unlock();
			this.open();
			Random rand = new Random();
			int tmp = rand.nextInt(10 + 1);
			if(tmp % 2 == 0){
				Game.printLetterByLetter("Wow !!! Where did you find this key ? The door is now unlocked. Who's the Good Boy ?\n", Script.DEFAULT_NARRATOR);
			}
			else{
				Game.printLetterByLetter("What a smart guy ! Haha just kidding, you got the key baby ! You unlocked the door !\n", Script.DEFAULT_NARRATOR);
			}
		}
		else if (key < this.KEY_LVL_NEED){
			Game.printLetterByLetter("You must have the good key to open this door STOOOPID CAVEMAN !\n", Script.DEFAULT_NARRATOR);
		}
	}


	// === OTHER ===

	@Override
	public void cross(Hero hero, String s){
		s = s.toLowerCase();
		this.unlock(hero.getKeyLevel()); //We test if the player get the right key
		if(this.isOpen()){
			hero.setPlace(this.getPlaces().get(s));     //If it's unlocked, we can pass
		}
	}

}
