package objectsTest;

import characters.Hero;
import objects.NaziPoster;
import objects.Potion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {

    private Potion p;
    private Hero h;

    @BeforeEach
    void setUp() {
        Place a = new Place("Place", false, true);

        h = new Hero("Test", a);

        p = new Potion(Script.DEFAULT_POTION_NAME);
        a.addObject(p);
    }

    @Test
    void take() {
        p.take(h);
        assertTrue(h.getObjs().containsValue(p));
        assertFalse(h.getPlace().getItems().containsValue(p));
    }

    @Test
    void look() {
        p.look();
    }

    @Test
    void use() {
        p.use(h);
        assertTrue(h.isImmun());
        assertFalse(h.getObjs().containsValue(p));
    }

    @Test
    void testUse() {
        p.use(h, "Test");
    }

    @Test
    void toStringTest() {
        System.out.println(p.toString());
    }
}