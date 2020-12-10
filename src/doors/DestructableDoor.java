package doors;

import characters.*;
import others.*;

public class DestructableDoor extends LockableDoor {

    // ***** CONSTRUCTOR *****

    public DestructableDoor(Place p1, Place p2) {
        super(p1, p2);
    }


    // ***** METHODS *****
    
    @Override
    public void cross(Hero hero, String s){
        s = s.toLowerCase();
        if(hero.getObjs().containsKey(Script.DEFAULT_CLUB_NAME) && !this.isUnlock()){ // If the hero has the Club
            this.unlock();
            this.open();
            System.out.print("\nCongrats, you destruct the door !\n");
            Game.printLetterByLetter("WHAT THE HELL DUDE !? IT'S JUST A SIMPLE DOOR ! WHAT'S YOUR F***ING PROBLEM ??? Hum...The door is open yet...\n", Script.DEFAULT_NARRATOR);
        }
        
        if(this.isUnlock()){
            hero.setPlace(this.getPlaces().get(s));
        }
        else{
            Game.printLetterByLetter("Although the outcome is doomed, this door seems DOWNRIGHT fragile.\n", Script.DEFAULT_NARRATOR);
        }
    }

}
