package doors;

import characters.*;
import others.*;

public class InfectedRoomDoor extends LockableDoor{


    // ***** CONSTRUCTOR *****

    public InfectedRoomDoor(Place p1, Place p2){
        super(p1, p2);
    }


    // ***** METHODS *****


    // === OTHER ===

    @Override
    public void cross(Hero hero, String s){
        if(!this.isUnlock()){
            if(hero.isImmun()) {
                this.unlock();
                this.open();
                System.out.println("You open the door, you're immunded of the nocif gas.");
                hero.setPlace(this.getPlaces().get(s));
            }
            else{
                System.out.println("The room seems like infected because of gas.");
            }
        }
        else{
            hero.setPlace(this.getPlaces().get(s));
        }
    }

}
