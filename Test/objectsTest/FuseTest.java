package objectsTest;

import characters.Hero;
import objects.ElectricityMeter;
import objects.Fuse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;
import others.Script;

import static org.junit.jupiter.api.Assertions.*;

class FuseTest {

    private Fuse f;
    private Hero h;
    private Place a;
    private ElectricityMeter e;

    @BeforeEach
    void setUp() {
        a = new Place("Place", false, false);

        f = new Fuse(Script.DEFAULT_FUSE_NAME);
        a.addObject(f);
        e = new ElectricityMeter(Script.DEFAULT_ELECTRICMETER_NAME, a);
        a.addObject(e);

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
        h.take(Script.DEFAULT_FUSE_NAME);
        assertTrue(h.getObjs().containsValue(f));
        assertFalse(h.getPlace().getItems().containsValue(f));

        // case with wrong objects
        f.use(h, "blabla");
        assertTrue(h.getObjs().containsValue(f));

        // case with ElectricMeter
        assertTrue(a.getItems().containsValue(e));
        f.use(h, Script.DEFAULT_ELECTRICMETER_NAME);
        assertTrue(e.getHasFuse());
        assertTrue(a.isEnlightened());
        assertFalse(h.getObjs().containsValue(f));

    }

    @Test
    void toStringTest() {
        System.out.println(f.toString());
    }
}