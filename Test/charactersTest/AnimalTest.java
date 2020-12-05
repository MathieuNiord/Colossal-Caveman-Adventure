package charactersTest;

import characters.Animal;
import characters.Hero;
import objects.Bescherelle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private Place a;
    private Hero h;
    private Animal cat;
    private Animal mouse;

    @BeforeEach
    void setUp() {
        a = new Place("Place", false, true);

        cat = new Animal("Cat",1,Script.CAT_TEXT01,
                Script.CAT_TEXT02,Script.CAT_DESCRIPT);
        mouse = new Animal("Mouse",2,Script.MOUSE_TEXT01,
                Script.MOUSE_TEXT02,Script.MOUSE_DESCRIPT);

        h = new Hero("Test", a);
    }

    @Test
    void testToString() {
        assertEquals(cat.NAME, cat.toString());
        assertEquals(mouse.NAME, mouse.toString());
    }

    @Test
    void talk() {
        Bescherelle b1 = new Bescherelle("b1");
        Bescherelle b2 = new Bescherelle("b2");
        a.addObject(b1);
        a.addObject(b2);
        assertTrue(a.getItems().containsValue(b1));
        assertTrue(a.getItems().containsValue(b2));

        // case without Bescherelle
        cat.talk(h);
        mouse.talk(h);
        assertEquals(0, h.getBLevel());

        // case with Bescherelle
        h.take("B1");
        assertTrue(h.getObjs().containsValue(b1));
        assertEquals(Hero.DEFAULT_BESCHERELLE_LEVEL +1, h.getBLevel());

        cat.talk(h);
        mouse.talk(h);

        // case with 2 Bescherelle
        h.take("B2");
        assertTrue(h.getObjs().containsValue(b2));
        assertEquals(Hero.DEFAULT_BESCHERELLE_LEVEL +2, h.getBLevel());

        cat.talk(h);
        mouse.talk(h);

    }

    @Test
    void look() {
        cat.look();
        mouse.look();
    }
}