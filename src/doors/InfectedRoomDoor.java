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
        s = s.toLowerCase();
        if(!this.isUnlock()){
            if(hero.isImmun()) {
                this.unlock();
                this.open();
                System.out.println("You open the door, you're immuned of the nocif gas.\n");
                hero.setPlace(this.getPlaces().get(s));
            }
            else{
                System.out.println("The room seems like infected because of gas.\n");
            }
        }
        else{
            hero.setPlace(this.getPlaces().get(s));
        }
    }

}
