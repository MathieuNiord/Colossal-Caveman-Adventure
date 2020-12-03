package objectsTest;

import characters.Hero;
import objects.Key;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;

import static org.junit.jupiter.api.Assertions.*;

class KeyTest {

    private Hero h;
    private Key k;

    @BeforeEach
    void setUp() {
        Place a = new Place("Place", false, true);

        k = new Key("Key");
        a.addObject(k);

        h = new Hero("Test", a);
    }

    @Test
    void use() {
        k.use(h);
    }

    @Test
    void testUse() {
        k.use(h);
    }

    @Test
    void take() {
        h.take("Key");
        assertTrue(h.getObjs().containsValue(k));
        assertFalse(h.getPlace().getItems().containsValue(k));
        assertEquals(Hero.DEFAULT_KEY_LEVEL+1, h.getKeyLevel());
    }

    @Test
    void look() {
        k.look();
    }
}