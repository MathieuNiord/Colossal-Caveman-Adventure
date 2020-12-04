package objectsTest;

import characters.Hero;
import objects.Flint;
import objects.Stick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class FlintTest {

    private Flint f;
    private Hero h;
    private Place a;

    @BeforeEach
    void setUp() {
        a = new Place("Place", false, false);

        f = new Flint("Flint");
        a.addObject(f);

        h = new Hero("Test", a);
    }

    @Test
    void take() {
        f.take(h);
        assertTrue(h.getObjs().containsValue(f));
        assertFalse(h.getPlace().getItems().containsValue(f));
    }

    @Test
    void look() {
        f.look();
    }

    @Test
    void use() {
        f.use(h);
    }

    @Test
    void testUse() {
        Stick s = new Stick("Stick");
        a.addObject(s);

        h.take("Stick");
        assertTrue(h.getObjs().containsValue(s));
        assertFalse(h.getPlace().getItems().containsValue(s));

        h.take("Flint");
        assertTrue(h.getObjs().containsValue(f));
        assertFalse(h.getPlace().getItems().containsValue(f));

        assertTrue(h.getObjs().containsValue(f));
        assertTrue(h.getObjs().containsValue(s));

        // case with the wrong objects
        f.use(h, "Banana");

        assertTrue(h.getObjs().containsValue(f));

        // case in the wrong room
        f.use(h, "Stick");

        assertTrue(h.getObjs().containsValue(f));
        assertTrue(h.getObjs().containsValue(s));

        // case in the right room
        Place B = new Place("Mortuary", false, true);
        h.setPlace(B);

        f.use(h, "Stick");

        assertFalse(h.getObjs().containsValue(f));
        assertFalse(h.getObjs().containsValue(s));
        assertTrue(h.getObjs().containsKey(Script.DEFAULT_FIREDSTICK_NAME));

    }

    @Test
    void toStringTest() {
        System.out.println(f.toString());
    }
}