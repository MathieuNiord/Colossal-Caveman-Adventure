package doors;

import characters.*;
import others.*;

import java.util.Random;

public class LockedKeyDoor extends LockableDoor{


	// ***** ATTRIBUTES *****

	public final int keyLvlNeed;


	// ***** CONSTRUCTOR *****

	public LockedKeyDoor(int key, Place p1, Place p2){
		super(p1, p2);
		this.keyLvlNeed = key;
	}


	// ***** METHODS *****


	// === GETTER ===
	

	// === SETTER ===

	@Override
	public void unlock(){
		if(!this.isUnlock()) {
			System.out.print("You do not have the access of this space.\n");
		}
	}

	public void unlock(int key){
		if(key >= this.keyLvlNeed && !this.isUnlock()) {
			super.unlock();
			Random rand = new Random();
			int tmp = rand.nextInt(10 + 1);
			if(tmp % 2 == 0){
				System.out.print("Wow !!! Where did you find this key ?\nThe door is now unlocked. Who's the Good Boy ?\n");
			}
			else{
				System.out.print("\nWhat a smart guy ! Haha just kidding, you got the key baby ! You unlocked the door !\n");
			}
		}
		else if (key < this.keyLvlNeed){
			System.out.print("You must have the good key to open this door STOOOPID CAVEMAN !\n");
		}
	}


	// === OTHER ===

	@Override
	public void cross(Hero hero, String s){
		this.unlock(hero.getKeyLevel()); //On teste si le joueur possède bien la clé nécessaire
		if(this.isUnlock()){
			hero.setPlace(this.getPlaces().get(s));     //Si c'est déverrouillé on peut passer
		}
	}

}