package objectsTest;

import characters.Hero;
import objects.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    private Weapon w;
    private Hero h;
    private Place a;

    @BeforeEach
    void setUp() {
        a = new Place("Place", false, false);

        w = new Weapon(Script.DEFAULT_CLUB_NAME);
        a.addObject(w);

        h = new Hero("Test", a);
    }

    @Test
    void take() {
        w.take(h);
        assertTrue(h.getObjs().containsValue(w));
        assertFalse(h.getPlace().getItems().containsValue(w));
    }

    @Test
    void use() {
        w.use(h);
    }

    @Test
    void testUse() {
        w.use(h, "test");
    }

    @Test
    void look() {
        w.look();
    }

    @Test
    void toStringTest() {
        System.out.println(w.toString());
    }
}