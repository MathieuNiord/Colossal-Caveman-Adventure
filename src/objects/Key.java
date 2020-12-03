package objects;

import characters.*;
import others.*;

public class Key extends Obj{

    // ***** CONSTRUCTOR *****

    public Key(String name) {
        super(name);
    }

    // ***** METHODS *****


    // === COMMANDS ===

    @Override
    public void use(Hero h) {
        Game.printLetterByLetter("What exactly are you trying to do with this key ?");
    }
    
    @Override
    public void use(Hero h, String s) {
    
    }
    
    @Override
    public void take(Hero h) {
        h.increaseKey();
        h.getObjs().put(this.NAME, this);
        h.getPlace().getItems().remove(this.NAME);
    }

    @Override
    public void look() {
        Game.printLetterByLetter(Script.KEY_DESCRIPT);
    }

}
