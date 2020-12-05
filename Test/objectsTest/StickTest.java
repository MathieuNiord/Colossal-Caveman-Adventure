package objectsTest;

import characters.Hero;
import objects.Flint;
import objects.Stick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class StickTest {

    private Stick s;
    private Hero h;
    private Place a;

    @BeforeEach
    void setUp() {
        a = new Place("Place", false, false);

        s = new Stick(Script.DEFAULT_STICK_NAME);
        a.addObject(s);

        h = new Hero("Test", a);
    }

    @Test
    void take() {
        s.take(h);
        assertTrue(h.getObjs().containsValue(s));
        assertFalse(h.getPlace().getItems().containsValue(s));
    }

    @Test
    void look() {
        s.look();
    }

    @Test
    void use() {
        s.use(h);
    }

    @Test
    void testUse() {
        Flint f = new Flint(Script.DEFAULT_FLINT_NAME);
        a.addObject(f);

        h.take(Script.DEFAULT_STICK_NAME);
        assertTrue(h.getObjs().containsValue(s));
        assertFalse(h.getPlace().getItems().containsValue(s));

        h.take(Script.DEFAULT_FLINT_NAME);
        assertTrue(h.getObjs().containsValue(f));
        assertFalse(h.getPlace().getItems().containsValue(f));

        // case with the wrong objects
        s.use(h, "Banana");

        assertTrue(h.getObjs().containsValue(s));

        // case with the good object
        s.use(h, Script.DEFAULT_FLINT_NAME);

        assertFalse(h.getObjs().containsValue(f));
        assertFalse(h.getObjs().containsValue(s));
        assertTrue(h.getObjs().containsKey(Script.DEFAULT_FIREDSTICK_NAME));

    }

    @Test
    void toStringTest() {
        System.out.println(s.toString());
    }
}