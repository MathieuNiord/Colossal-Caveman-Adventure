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
				System.out.print("Wow !!! Where did you find this key ?\nThe door is now unlocked. Who's the Good Boy ?\n");
			}
			else{
				System.out.print("\nWhat a smart guy ! Haha just kidding, you got the key baby ! You unlocked the door !\n");
			}
		}
		else if (key < this.KEY_LVL_NEED){
			System.out.print("You must have the good key to open this door STOOOPID CAVEMAN !\n");
		}
	}


	// === OTHER ===

	@Override
	public void cross(Hero hero, String s){
		this.unlock(hero.getKeyLevel()); //We test if the player get the right key
		if(this.isOpen()){
			hero.setPlace(this.getPlaces().get(s));     //If it's unlocked, we can pass
		}
	}

}
