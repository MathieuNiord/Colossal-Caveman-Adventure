package Doors;

import Characters.*;
import Others.*;

public class InfectedRoomDoor extends LockableDoor{

    public InfectedRoomDoor(Place p1, Place p2){
        super(p1, p2);
    }

    @Override
    public void cross(Hero hero, String s){
        if(!this.isUnlock()){
            if(hero.isImmun()) {
                this.unlock();
                System.out.println("You open the door, you're immunded of the nocif gas.");
                hero.setPlace(this.getPlaces().get(s));     //Si c'est déverrouillé on peut passer
            }
            else{
                System.out.println("The room seems like infected because of gas.");
            }
        }
        else{
            hero.setPlace(this.getPlaces().get(s));     //Si c'est déverrouillé on peut passer
        }
    }
}
