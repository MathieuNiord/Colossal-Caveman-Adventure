package Objects;

import Characters.*;
import Others.*;

public class Key extends Obj{
    public Key(String name) {
        super(name);
    }

    @Override
    public void use(Hero h) {
        System.out.println("What exactly are you trying to do with this key ?");
    }

    @Override
    public void take(Hero h) throws InterruptedException {
        h.increaseKey();
        h.getObjs().put(this.NAME, this);
    }

    @Override
    public void look() throws InterruptedException {
        Game.printLetterByLetter(Script.KEY_DESCRIPT);
    }
}
