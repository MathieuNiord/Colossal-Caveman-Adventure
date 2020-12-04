package objectsTest;

import characters.Hero;
import objects.FiredStick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;

import static org.junit.jupiter.api.Assertions.*;


class FiredStickTest {

    private FiredStick f;
    private Hero h;

    @BeforeEach
    void setUp() {

        Place a = new Place("PlaceA", false, true);

        f = new FiredStick("FiredStick");
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
    void use2() {
        f.use(h, "test");
    }

    @Test
    void toStringTest() {
        System.out.println(f.toString());
    }
}