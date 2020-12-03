package objectsTest;

import characters.Hero;
import objects.Bescherelle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;

import static org.junit.jupiter.api.Assertions.*;

class BescherelleTest {

    private Hero h;
    private Bescherelle b;

    @BeforeEach
    void setUp() {
        Place a = new Place("Place", false, true);

        b = new Bescherelle("Bescherelle");
        a.addObject(b);

        h = new Hero("Test", a);
    }

    @Test
    void use() {
        b.use(h);
    }

    @Test
    void use2() {
        b.use(h, "blabla");
    }

    @Test
    void take() {
        h.take("Bescherelle");
        assertTrue(h.getObjs().containsValue(b));
        assertFalse(h.getPlace().getItems().containsValue(b));
        assertEquals(Hero.DEFAULT_BESCHERELLE_LEVEL+1, h.getBLevel());
    }

    @Test
    void look() {
        b.look();
    }
}